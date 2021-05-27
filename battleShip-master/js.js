// get the element that have the id myContainer 
var container = document.getElementById("myContainer");

// function makeVamp , this function get two parameters , the first of them is for the number of rows and columns 
// and the second widthAndHright for set width and height for each one of myContainer and father-contaner 
function makeVamp(square,widthAndHeight) {
  document.getElementById("myContainer").style.width = widthAndHeight;
  document.getElementById("myContainer").style.height = widthAndHeight;

  document.getElementById('father-container').style.width = widthAndHeight;
  document.getElementById('father-container').style.height = widthAndHeight;

  container.style.setProperty("--grid-rows", square);
  container.style.setProperty("--grid-cols", square);

  // in this loop we will create a new tag ' div ' and giv it a class " grid-item" and put all of them in a one parent , that parent is the container 
  for (var c = 0; c < square * square; c++) {
    let cell = document.createElement("div");
    container.appendChild(cell).className = "grid-item";
  }
  // after we created those elements will get then in one variable ' list '
  var divVariable = document.getElementsByClassName("grid-item");
  // makeIds will give an id for each element from the divVariable
  makeIDs();
  function makeIDs() {
    var divElement = 0;
    for (var i = 0; i < matrix ; i++) {
      for (var j = 0; j < matrix ; j++) {
        theCharCase = String.fromCharCode(i+97);
        // set id for this element 
        divVariable[divElement].setAttribute("id",theCharCase+j);
        divElement++;
      }
    }
  }
  // for make border for the elements selected in the function 
  border();
  function border(){
    // for radius 
    document.getElementById('a0').style.borderTopLeftRadius = '10px';
    document.getElementById('a'+(matrix - 1)).style.borderTopRightRadius = '10px';
    document.getElementById(String.fromCharCode(97 + matrix - 1)+'0').style.borderBottomLeftRadius = '10px';
    document.getElementById(String.fromCharCode( 97 + matrix - 1)+( matrix - 1)).style.borderBottomRightRadius = '10px';
  }
}

// for set width and height for the father 
var widthAndHeight;
// calcule drowned boats 
var boatsDrowned;
// stock char in this variable 
var theCharCase;

// list of letters 
var columnsLetters;
var rows;
var columns;
// numberOfBoats ( number from the computer set it in the begging)
var numberOfBoats ;
// maxTries has a realation with the number of rows and columns 
var maxTries;

// the boats chosen in the begging of the game by the computer
var chosenBoats ;
// just a variable for chosenBoats
var xs ;
var theSelectedItem;

// listView for the list in the right of the page 
var listView;
// number of elements incremented by one 
var listConter ;

// we save every element that we have click on it 
var listClicked ;
// thisItemDoesNotExist , when we select an item we will save it in a list "listClicked", so we check the new element with the old elements if it was not in the list then we add it and thisItemDoesNotExist will stay true , but when we found that element in the list it gonna be false , and we will use this after in condition 
var thisItemDoesNotExist ;

// change the ids from lowercase to uppercase 
var upperCaseIds;

// it means how did this player click in the board
var equalMaxTries;

// start from here call makeVamp then call initialize 
  //* makeVamp will create new divs and gave them a class name then call the intern function makeIds and the function border 
    //? makeIds will give id for each div from those divs who that created by makeVamp function
    //? border will give border radius to every div selected in the function 
  //TODO //* initialize call deleteAllIds  
    //TODO //? deleteAllIds will delete every id in the grid 
  //* initialize will set the number of numberOfBoats variable by calling the function setNumberOfBoats
    //? setNumberOfBoats set value by condition
  //* initialize call makeArrays 
    //? makeArrays has a function it will be called its name is changeToIDs
      //! changeToIDs changes number to one string
  //* then initialize will set the chosenBoats and set the rest of other values 


start();
async function start(){
  do{
    var getValueFromWindowSwal;
    await swal("Enter A Number Between 5 And 9 :", {content: "input", className: "swal-text" }).then((value) => { getValueFromWindowSwal = `${value}`; });
    
    matrix = parseInt(getValueFromWindowSwal);
    widthAndHeight = ((matrix * 60 )+ (matrix * 5 )) + 'px';
  }while(matrix > 9 || matrix < 5);

  makeVamp(matrix , widthAndHeight);
  initialize();
}


// this function will not end until columns length will the same as numberOfBoats
function makeArrays(){
  for(var i = 0 ; rows.length < numberOfBoats ; i++){
    generateArray(rows);
  }
  // this function will not end until columns length will the same as numberOfBoats
  for(var i = 0 ; columns.length < numberOfBoats ; i++){
    generateArray(columns);
  }
  // this function with make a random array with conditions 
  function generateArray(arr){
    // the smallest random number can we get 
    var min = 0;
    // the biggest random number can we get 
    var max = matrix - 1;
    bool = true;
    // save the value in a random variable 
    random = Math.floor(Math.random()*(max-min+1)+min);
    // if the arr was empty then push the first element " random " like this 
    if(arr.length<1){
      arr.push(random);
    }
    // if there id an element in the arr then go into this else and make a loop with test , the previous elements and the new element , if this element was there then the function will generate another number until got a new number not in the list 
    else
    {
      for(var j = 0 ; j < arr.length ; j++){    
        if(random == arr[j]){
          bool = false;
          break;
        }
      }
      if(bool){
        arr.push(random);
      }
    }
  }

  // when we get random number we will turn them to characters with this function and put them in the list that has the name columnsLetters

  // then now we have columnsLetters list for the latters and row for the numbers 
  changeToIDs(columns);
  // changeToIDs it change the random number to a charachter 
  function changeToIDs(arr){
    for (var i = 0; i< arr.length; i++) {
      theCharCase = String.fromCharCode(arr[i]+97);
      columnsLetters.push(theCharCase);
    }
  }
}

// setNumberOfBoats with condition 
function setNumberOfBoats(){
  if(matrix <= 5){
    return 2;
  }
  else if(matrix <= 7){
    return 3;
  }
  else if(matrix <= 10){
    return 4;
  }
  else{
    return 5;
  }
}

// setMaxTries with condition 
function setMaxTries(){
  if(matrix <= 5){
    return 17;
  }
  else if(matrix <= 6){
    return 23;
  }
  else if(matrix <= 7){
    return 31;
  }
  else if(matrix <= 8){
    return 44;
  }
  else {
    return 63;
  }
}

// initialize function for set variable in the begining of excution 
function initialize(){
  columnsLetters = [] ;
  rows           = [] ;
  columns        = [] ;
  numberOfBoats  = setNumberOfBoats();
  maxTries       = setMaxTries();
  boatsDrowned   = 0  ; 
  chosenBoats    = [] ;
  makeArrays();
  for(var i = 0 ; i < numberOfBoats ; i++ ){
    xs = columnsLetters[i] + rows[i];
    chosenBoats.push(xs);
  }
  listView       = document.getElementById("listview");  // Find the element
  listConter     = 0  ;
  listClicked    = [] ;
  equalMaxTries  = 0
}

// this function will start when the mouse clicked with any click 
// will get the name of the elemnt that we have click on 
// if the id element was "#MyButton" the call the function start 
// else if the number of the boatsDrowned less than numberOfBoats then we will see if it selected before or not 
// will save every item selected in list listClicked for testing later if we have selected that item 
// if thisItemDoesNotExist was true than will test the length of the string that we got , 
// if theSelectedItem  was equal 2 then will call the fnction checkValue and send theSelectedItem 
  //? checkValue recieve a parameter theSelectedItem , give it name idSelected 
  //? checkValue will set didNotDrown as a true
  //? checkValue will test every chosenBoats with the idSelected if we got true with one element from chosenBoats then set didNotDrown as a false
  //? and run a setTimeOut funtion after 500ms if boatsDrowned was equal to numberOfBoats 
  //? in case of didNotDrown was true then we make a big square containe eight elements  around idSelected (theSelectedItem) and add them to touchArray
  //? we use variable : 
    //! first for the first lettre
    //! last for the last lettre and then change it to a number 
    //! firstPre for the previous lettre and firstNext for the Next lettre >  from first 
    //! lastPre for the previous number and lastNext for the Next number   >  from last 
    //! touchElement1 and touchElement2 for convert from ascci code to letters
  //? then will set a variable changeStyleBoolean as false
// we will create a new elements "div" and gave them a class name list-itme and then give an id to every one of them 
// we add those elements to display theSelectedItem name in theListItemSelected and theListItemSelected has a parent his name is  listView every time we click on it (theSelectedItem)


// listner function 
$(document).ready(function(){
    $(document).click(function(event){

      if((equalMaxTries) != maxTries){

        if(boatsDrowned < numberOfBoats){
          theSelectedItem = event.target.id;
          thisItemDoesNotExist = true;
          for( var i = 0 ; i < listClicked.length ; i++){
            if(listClicked[i] == theSelectedItem){
              thisItemDoesNotExist = false;
            }
          }
          
          if(thisItemDoesNotExist){
            if(theSelectedItem.length == 2){
              listClicked.push(theSelectedItem);
            }
          }
          if(thisItemDoesNotExist){
                if(theSelectedItem.length == 2){
                  checkValue(theSelectedItem);
                  let list = document.createElement("div");
                  listView.appendChild(list).className = "list-item";
                  var listItem = document.getElementsByClassName("list-item");
                  listItem[listConter].setAttribute("id","myId"+listConter);
                  var theListItemSelected = document.getElementById("myId"+listConter);
                
                  upperCaseIds = theSelectedItem.charAt(0).toUpperCase() + theSelectedItem.charAt(1)

                  theListItemSelected.innerHTML = upperCaseIds;
                  listConter++;            
                }
              }
        // this will display when the player wants to click but the game has ended 
        }else{
          swal(
            "The Game Was Ended", {
              buttons: false,
              timer: 1500,
          }
          );
        }
      }
      // this will display when the player wants to click but the game has ended 
      else{
        swal(
          "The Game Was Ended", {
            buttons: false,
            timer: 1500,
        }
        );
      }
    });
});

function checkValue(idSelected){
  var touchArray = [];
  var didNotDrown = true;

  for(var i = 0 ; i < numberOfBoats ; i++ ){
    if (idSelected == chosenBoats[i]){
      document.getElementById(idSelected).style.background = 'rgba(113, 233, 83,0.7)';
      document.getElementById(idSelected).style.backgroundImage = "url('drown.png')";
      document.getElementById(idSelected).style.backgroundRepeat = "no-repeat";
      document.getElementById(idSelected).style.backgroundSize = "60px 60px";

      console.log("you have the goal");
      boatsDrowned++;
      didNotDrown = false;
      // this will display the message of winning when numberOfBoats ( number from the computer set it in the begging) and boatsDrowned (number incriments by one when we got a boat)
      setTimeout(function() { 
        if( boatsDrowned == numberOfBoats ){
          swal("Good job!", "You Win The Game", "success");
        } 
      }, 500);
      // setTimeout this will set the background 
      setTimeout(function() { 
        console.log(equalMaxTries);
        document.getElementById("myId"+(equalMaxTries-1)).style.background = "rgba(113, 233, 83,0.7)";
      }, 0);
    }
  }

  equalMaxTries++;

  // make a list with the elements around the element clicked when didNotDrown was true 
  if(didNotDrown){ 

    // main letter   row
    var x = idSelected.charAt(0);
    let first = idSelected.charCodeAt(0);
    // main number   column
    let last = parseInt(idSelected.charAt(1));
    
    // ascci code for numbers 
    let firstPre  = first-1;
    let firstNext = first+1;

    // numbers
    let lastPre = last-1;
    let lastNext = last+1;
  
    // letters
    var touchElement1 = String.fromCharCode(firstPre);
    var touchElement2 = String.fromCharCode(firstNext);

    /*********         add the elements to the list touchArray       ***********/
    if (( firstPre > 96 )  && lastPre >-1 ){
      touchArray.push( touchElement1 + lastPre );  
    }
    if ( firstPre > 96 ){
        touchArray.push( touchElement1 + last );    
    }
    if ((firstPre > 96)  && lastNext < matrix ){
      touchArray.push( touchElement1 + lastNext );
    }
    if (lastPre > -1 ){
        touchArray.push( x + lastPre );
    }
    if (lastNext < matrix ){
        touchArray.push( x + lastNext );
    }
    if ((firstNext < 97 + matrix )  && lastPre > -1 ){
        touchArray.push( touchElement2 + lastPre ); 
    }
    if ((firstNext < 97 + matrix )){
        touchArray.push( touchElement2 + last ); 
    }   
    if ((firstNext < 97 + matrix )  && lastNext < matrix ){
        touchArray.push(touchElement2+lastNext);
    }
    /*********       End of adding the elements to the list touchArray       *********/

    var changeStyleBoolean = false ;

    for(var i = 0 ; i < touchArray.length ; i++ ){
      for(var j = 0 ; j < chosenBoats.length; j++){
        if (chosenBoats[j] == touchArray[i]){
          changeStyleBoolean = true;
        }
      }
    }
    // for add the image almost.png it means you got a point in side of the boat 
    if(changeStyleBoolean){
      document.getElementById(idSelected).style.background = 'rgba(255,69,0,0.7)';
      document.getElementById(idSelected).style.backgroundImage = "url('almost.png')";
      setBackground();
    }
    // for add  the image fault.png it means you got a point far from the boat 
    else{
      document.getElementById(idSelected).style.background = 'rgba(254,18,18,0.7)';
      document.getElementById(idSelected).style.backgroundImage = "url('fault.png')";
      setBackground();
    }
    // set images as a background " almost and fault " with no-repeat and set the width and the height and borders 
    function setBackground(){
      document.getElementById(idSelected).style.backgroundRepeat = "no-repeat";
      document.getElementById(idSelected).style.backgroundSize = "60px 60px";
      // for radius 
      document.getElementById('a0').style.borderTopLeftRadius = '10px';
      document.getElementById('a'+(matrix - 1)).style.borderTopRightRadius = '10px';
      document.getElementById(String.fromCharCode(97 + matrix - 1)+'0').style.borderBottomLeftRadius = '10px';
      document.getElementById(String.fromCharCode( 97 + matrix - 1)+( matrix - 1)).style.borderBottomRightRadius = '10px';
    }
  }

  // timeOut function  when the player run out of his clicks this swal gonna display a message 
  setTimeout(function() { 
    if((equalMaxTries == maxTries)&&(boatsDrowned != numberOfBoats)){
      swal("You Lose! ","You have clicked " + (equalMaxTries) + " times", "error");
    }
  }, 200);
}