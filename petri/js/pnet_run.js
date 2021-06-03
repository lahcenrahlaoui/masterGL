var RunList = [];
var RunIcon = null;
var ExitRun = false;     
var IsRunning = false;
var AnimateDelay = 500;

function StartRun() {
    IsRunning = true;
    ExitRun = false;
    RunIcon = new RunIconInitialize(AnimateDelay);
    Run();
}
function StopRun() {
    ExitRun = true;
    IsRunning = false;
}

function Run(){
    RunList = [];
    Object.keys(Places).forEach(function (key, ind) { Places[key].tokens_count = Places[key].tokens.length; });

    if (!ExitRun) {
        Object.keys(Trans).forEach(function (key, ind) {       
            var arcsIn = get_arcsIn(key);
            if (ready_toFire(arcsIn)) {
                var run_item = {};
                run_item.tran = Trans[key];
                run_item.arcsIn = arcsIn;
                run_item.arcsOut = get_arcsOut(key);
                run_item.temp_tokens = [];
                RunList.push(run_item);
            }
        });
        animate_list();
    }
    else
    {
        RunIcon.remove();
    }
}

function animate_list()
{
    animate1();
    RunIcon.animate1();     
}
function animate1()
{
    RunList.forEach(function (run_item, ind) {
        run_item.arcsIn.forEach(function (arc, ind) {			                            
            if (arc.from.tokens.length > 0)
            {
                var animation = Raphael.animation(new XY(arcX2(arc), arcY2(arc)), AnimateDelay, "easeIn");
                var ttoken = arc.from.tokens.pop();                                            
                if (typeof ttoken != "undefined" && ttoken.hasOwnProperty('type'))             
                {
                    ttoken.remove();                                                           
                }
                ttoken = paper.circle(arcX1(arc), arcY1(arc), TN_RADIUS).attr(token_attr);            
                redraw_tokens(arc.from, arc.from.x, arc.from.y);
                run_item.temp_tokens.push(ttoken);                                            
                run_item.temp_tokens[run_item.temp_tokens.length - 1].animate(animation);     
            }
        });
    });
}
function animate2()
{
    RunList.forEach(function (run_item, ind) {
        run_item.temp_tokens.forEach(function (token, ind) { token.remove(); });
        run_item.temp_tokens = [];
        run_item.arcsOut.forEach(function (arc, ind) {			
            
            var token = paper.circle(arcX1(arc), arcY1(arc), TN_RADIUS).attr(token_attr);
            var animation = Raphael.animation(new XY(arcX2(arc), arcY2(arc)), AnimateDelay, "easeIn");
            run_item.temp_tokens.push(token);
            token.animate(animation);
        });
    });
    RunIcon.animate2();      
}
function animate3() {
    RunList.forEach(function (run_item, ind) {
        run_item.temp_tokens.forEach(function (token, ind) { token.remove(); });
        run_item.temp_tokens = [];
        run_item.arcsOut.forEach(function (arc, ind) {			 
            AddToken(arc.to);
        });
    });
    Run();
}

//Updated: 3.02.2017
function ready_toFire(arcsIn) {
    var isReady = true;
    arcsIn.forEach(function (item, ind) {
        if (item.from.tokens_count <= 0) {
            isReady = false;
        }
        else {
            item.from.tokens_count--;
        }
    });
    if (!isReady) { 
        arcsIn.forEach(function (item, ind) { item.from.tokens_count = item.from.tokens.length; });
    }
    return isReady;
}

function get_arcsIn(key)
{
    var arcsIn = [];
    Arcs.forEach(function (item, index) {
        if (item.to.key == key) {
            arcsIn.push(item);
        }
    });
    return arcsIn;
}
function get_arcsOut(key) {
    var arcsOut = [];
    Arcs.forEach(function (item, index) {
        if (item.from.key == key) {
            arcsOut.push(item);
        }
    });
    return arcsOut;
}
function RunIconInitialize(delay)
{
    var x = 25;
    var y = PAPER_HEIGHT - 10;
    var width = 40;
    var height = 2;
    var r = 4;

    this.img = paper.circle(x, y, r).attr({"fill":"white", "stroke":"white"});
    this.animation1 = Raphael.animation(new XY(x + width, y), delay, "easyin", animate2);
    this.animation2 = Raphael.animation(new XY(x, y), delay, "easyin", animate3);
    this.animate1 = function () { this.img.animate(this.animation1); };
    this.animate2 = function () { this.img.animate(this.animation2); };

    this.remove = function () {
        this.img.remove();
    };
}

function arcX1(arc) {
    return arc.img.attrs.path[0][1];
}
function arcY1(arc) {
    return arc.img.attrs.path[0][2];
}
function arcX2(arc) {
    return arc.img.attrs.path[1][1];
}
function arcY2(arc) {
    return arc.img.attrs.path[1][2];
}
