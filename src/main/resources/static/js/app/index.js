alert('index.js 확인');

var main = {
    //메인화면 초기화
    alert('index.js 확인2');
    init : function(){
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    }

    //글 등록 버튼 클릭시 호출되는 메소드
    save : function() {
        alert('ddd');
        var data = {
            title: $('#title'). val(),
            content: $('#content'). val(),
            author: $('#author'). val()
        };

        $.ajax({
            type : 'POST',
            url : '/api/v1/posts',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function(){ //성공시
            alert('글이 등록되었습니다.');
            window.location.href='/'; //글 등록 후 메인화면으로 이동
        }).fail(function(error){ //실패시
            alert(JSON.stringify(error)); //에러 내용 출력
        });
    }
};

    main.init();