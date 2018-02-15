$(document).ready(function() {
  var zoznam=$("#zoznam");
  $.ajax({

         url: 'http://localhost:8080/world/countries',
         data : { } ,
         error : function(){
             $("#error").html("chyba");
         },
	 success : func,
         crossDomain: true,
         dataType: 'jsonp',
         jsonpCallback: 'func',
		 contentType: 'application/json',
		 type:'GET'
  });

  function func(data){
       //console.log(data);
       data.name.forEach(function(element) {
         $('#zoznam').append( '<option value="'+element+'">'+element+'</option>' );
       });
  }

  $("#zoznam").change(function ()
  {
      //console.log("zmena: "+$(this).val());
      $.ajax({

             url: 'http://localhost:8080/world/cities/'+$(this).val(),
             data : { } ,
             error : function(){
                 $("#error").html("chyba");
             },
    	 success : showCities,
             crossDomain: true,
             dataType: 'jsonp',
             jsonpCallback: 'showCities',
    		 contentType: 'application/json',
    		 type:'GET'
      });
  });
  function showCities(data){
       console.log(data);
       $('#listofcities').empty();
       data.name.forEach(function(element) {
         $('#listofcities').append( '<option value="'+element+'">'+element+'</option>' );
       });
  }

  $("#listofcities").change(function ()
  {
    $.ajax({

           url: 'http://localhost:8080/world/population',
           data : JSON.stringify({ "name": $(this).val() }) ,
           error : function(){
               $("#error").html("chyba");
           },
     success : showPopulation,
           crossDomain: true,
           dataType: 'jsonp',
           jsonpCallback: 'showPopulation',
       contentType: 'application/json',
       type:'POST'
    });
  });

  function showPopulation(data){
  }
});
