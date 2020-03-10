
function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

$.Put = function(url,data,callback){
    $.ajax({
        url:url,
        type:"put",
        contentType:"application/json",
        dataType:"json",
        data:data,
        timeout:60000,
        success:function(msg){
            callback(msg);
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){

        }
    });
	};
	
	$.Post = function(url,data,callback){
        $.ajax({
            url:url,
            type:"post",
            contentType:"application/json",
            dataType:"json",
            data:data,
            timeout:20000,
            success:function(msg){
                callback(msg);
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){

            }
        });
    };

	$.Delete = function(url,data,callback){
        $.ajax({
            url:url,
            type:"delete",
            contentType:"application/json",
            dataType:"json",
            data:data,
            success:function(msg){
                callback(msg);
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){

            }
        });
    };

function callDone(result){
	var templateExample = _.template($('#templateExample').html());

	var html = templateExample({
		"attribute":JSON.stringify(result)
	});

	$("#result").append(html);
}

$(function(){
	$("#button").click(function(){
		getServerData("/ws/example/aircraft",callDone);
	});
});