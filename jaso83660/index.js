TimerCount();

function TimerCount(){

  $.get("updatetime.txt", function (data){

            const dataArray = data.split(',');  // カンマで分割
            const upDateStart = new Date(parseInt(dataArray[0]), parseInt(dataArray[1]), parseInt(dataArray[2]), parseInt(dataArray[3]), parseInt(dataArray[4]),0, 0);
            const upDateEnd = new Date(parseInt(dataArray[0]), parseInt(dataArray[1]), parseInt(dataArray[2]), parseInt(dataArray[3]), parseInt(dataArray[4]),2, 0);
            const currentDate= new Date(Date.now() + ((new Date().getTimezoneOffset() + (9 * 60)) * 60 * 1000));

            if(currentDate.getTime() >= upDateStart.getTime() && currentDate.getTime() <= upDateEnd.getTime()) {
              window.location.reload();
            } 
        }
  );

    setTimeout("TimerCount()",1000);
}
