
let countTurtle = {
	getGraph: function() {
        let timeList = new Array();
        let posList = new Array();
                    //                mb_id: "${signIn.mb_id}",
        var param = {
                        mb_id: 'adkim',
                        pos_type: '거북목'
                    };
        console.log(JSON.stringify(param));
        $.ajax({
            url: '/page/chart/countTurtle.html',
//            type: 'GET',
//            data: param,
            type: "POST",
            data: JSON.stringify(param),
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            success: function(data){
                console.log(data);
                 console.log(data[0].pos_count);
                // 그래프로 나타낼 자료 리스트에 담기
                for(let i=0; i<data.length; i++){
                    timeList.push(data[i].pos_time);
                    posList.push(data[i].pos_count);
                }
                 console.log(timeList);
                 console.log(posList);
                // 그래프
                new Chart(document.getElementById("line-chart"),{
                type: 'line',
                data: {
                    labels: timeList, // X출
                    datasets: [{
                        data: posList, // 값
                        label: "거북목",
                        borderColor: "#3e95cd",
                        fill: false
                    }]
                },
                options: {
                    title: {
                        display: true,
                        text: '추간 거북목'
                    }
                }
                }); // 그래프
            },
            error: function(){
                alert("실패");
            }
        }) // ajax
    } // getGraph
}
countTurtle.getGraph();

//$.ajax({
//    type : 'post',           // 타입 (get, post, put 등등)
//    url : '/test',           // 요청할 서버url
//    async : true,            // 비동기화 여부 (default : true)
//    headers : {              // Http header
//      "Content-Type" : "application/json",
//      "X-HTTP-Method-Override" : "POST"
//    },
//    dataType : 'text',       // 데이터 타입 (html, xml, json, text 등등)
//    data : JSON.stringify({  // 보낼 데이터 (Object , String, Array)
//      "no" : no,
//      "name" : name,
//      "nick" : nick
//    }),
//    success : function(result) { // 결과 성공 콜백함수
//        console.log(result);
//    },
//    error : function(request, status, error) { // 결과 에러 콜백함수
//        console.log(error)
//    }
//})

// data:
// get param -> requestParam map
// post JSON.stringify(param) -> requestBody map
// post param -> requestBody string
