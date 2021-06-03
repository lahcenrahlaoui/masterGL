var textFile = null;
var LS_ITEM_NAME = "pnet_local";
var LS_SETTINGS = "pnet_settings";

function RestoreSettings()
{
    var settings = JSON.parse(localStorage.getItem(LS_SETTINGS));
    if (typeof settings != "undefined" && settings != null)
    {
        if (!settings.use_default) {
            PAPER_WIDTH = settings.paper_width;
            PAPER_HEIGHT = settings.paper_height;
            PL_RADIUS = settings.place_radius;
            TN_RADIUS = settings.token_radius;
        }
    }
    console.log(settings);
}
function SaveSettings()
{
    var settings = {};
    settings.use_default = document.getElementById("use_default").checked;
    settings.paper_width = document.getElementById("paper_width").value;
    settings.paper_height = document.getElementById("paper_height").value;
    settings.place_radius = document.getElementById("place_radius").value;
    settings.token_radius = document.getElementById("token_radius").value;
    localStorage.setItem(LS_SETTINGS, JSON.stringify(settings));
}

function SaveToLocalStorage()
{
    var text = SerializePnet(Places, Trans, Arcs);
    localStorage.setItem(LS_ITEM_NAME, text);
}
function SerializePnet(Places, Trans, Arcs)
{
    var pn = { places:[], trans:[], arcs:[] };

    Object.keys(Places).forEach(function (key) {
        pn.places.push(Places[key].pnString());
    });
    Object.keys(Trans).forEach(function (key) {
        pn.trans.push(Trans[key].pnString());
    });
    Arcs.forEach(function (item, index) {
        pn.arcs.push(item.pnString());
    });
    //console.log(JSON.stringify(pn));
    return JSON.stringify(pn);
}

function RestoreFromLocalStorage()
{
    var pn = JSON.parse(localStorage.getItem(LS_ITEM_NAME));
    DeserializePnet(pn);
}
function DeserializePnet(pn)
{
    Places = {};
    Trans = {};
    Arcs = [];
    pn.places.forEach(function (item, index) {
        var a = item.split(",");
        var p = AddPlace(a[0], Number(a[1]), Number(a[2]), Number(a[3]));
    });
    pn.trans.forEach(function (item, index) {
        var a = item.split(",");
        var t = AddTransition(a[0], Number(a[1]), Number(a[2]));
    });
    pn.arcs.forEach(function (item, index) {
        var a = item.split(",");
        var t = AddArc(getByKey(a[0]), getByKey(a[1]));
        console.log(getByKey(a[0]))
    });
}

function SaveToFile(file_name)
{
    var text = SerializePnet(Places, Trans, Arcs);
    DownloadToFile(file_name, text);
}
function ReadFromFile(file, handler) {
    var reader = new FileReader();
    reader.onload = handler;
    try {
        reader.readAsText(file);
    }
    catch (err) {
        console.log(err.message);
    }
}
function DownloadToFile(file_name, text)
{
    var link = document.createElement("a");
    link.setAttribute("download", file_name);
    link.href = create_file(text);
    document.body.appendChild(link);
    //
    window.requestAnimationFrame(function () {
        var event = new MouseEvent('click');
        link.dispatchEvent(event);
        document.body.removeChild(link);
    });
};
function create_file(text) {
    var data = new Blob([text], { type: 'text/plain' });
   //
    if (textFile !== null) {
        window.URL.revokeObjectURL(textFile);
    }
    url = window.URL.createObjectURL(data);
    //
    return url;
};







