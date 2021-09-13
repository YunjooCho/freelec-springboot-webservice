var main = {
    //메인화면 초기화
    init : function(){
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function(){
            _this.update();
        });

        $('#btn-delete').on('click',function(){
            _this.delete();
        });
    },

    //글 등록 버튼 클릭시 호출되는 메소드
    save : function() {
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
    },

    //수정 완료 버튼 클릭시 호출되는 메소드
    update : function(){
        var data = {
            title: $('#title'). val(),
            content: $('#content'). val()
        };

        var id = $('#id').val();
        $.ajax({
            type : 'PUT',
            url : '/api/v1/posts/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=uft-8',
            data : JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },

    //삭제 버튼 클릭시 호출되는 메소드
    delete : function(){
        var id = $('#id').val();

        $.ajax({
            type : 'DELETE',
            url : '/api/v1/posts/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=uft-8'
        }).done(function(){
            alert('글이 삭제되었습니다');
            window.location.href = '/';
        }).fail(function(error){
            alert(JSON.stringify(error));
        });
    }
};

main.init();