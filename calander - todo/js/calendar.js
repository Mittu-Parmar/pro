
var dt = new Date();
function loadDate(){

dt.setDate(1);
var day = dt.getDay();
var endDate=new  Date(
    dt.getFullYear(),
    dt.getMonth() +1, 
    0
).getDate();

var prevDate=new  Date(
    dt.getFullYear(),
    dt.getMonth() , 
    0
).getDate();

var today = new Date();

var months = [
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
    "August",
    "September",
    "October",
    "November",
    "December"
];

document.getElementById("month").innerHTML = months[dt.getMonth()];
document.getElementById("date_str").innerHTML = dt.getFullYear();

var cells = ""; 

for (x = day; x > 0 ; x--) {
    cells += "<div class='prev_date'>"+ (prevDate - x +1)  +"</div>";
}

for (i = 1; i <= endDate; i++) {
    if(i==today.getDate() && dt.getMonth() == today.getMonth()){
        cells += "<div class='today'>"+i+"</div>";
    }else{
        cells += "<div>"+i+"</div>";
    }
    
}

document.getElementsByClassName("days")[0].innerHTML = cells;

}

function moveDate(para){
    if(para == 'prev'){
        dt.setMonth(dt.getMonth() -1 );
    }else {
        dt.setMonth(dt.getMonth() + 1);
    }    
    loadDate();
}

setInterval(changeTime,500)
function changeTime(){
    var time= new Date();
    var h=time.getHours();
    var m=time.getMinutes();
    var s=time.getSeconds();

    if(h>12){
        h=h-12;
    }

    if(h==0){
        h=10;
    }

    document.getElementById("time").innerHTML = (h<10?"0"+h:h) +":"+(m<10?"0"+m:m)+":"+(s<10?"0"+s:s) +" "+ (h>12?"PM":"AM");
}




