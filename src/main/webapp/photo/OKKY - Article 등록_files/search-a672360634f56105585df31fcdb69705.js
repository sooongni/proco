$(function(){$("#search-google").on("shown.bs.popover",function(){$("#search-google-popover").find('input[name="qt"]').get(0).focus()});$("#search-google").popover({container:"body",title:"Google 검색",placement:"right",content:$("#search-google-form").clone().attr("id","search-google-popover")[0],html:true});$("body").delegate('form[name="searchMain"]',"submit",function(){var e=$(this)[0];e.q.value="site:okky.kr "+e.qt.value})})