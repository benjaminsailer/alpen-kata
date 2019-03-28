$(document).ready(function(){
    $('#results').hide();
});

function fetchResults() {
	var country = $('#country')[0].value;
	var hFrom = $('#hFrom')[0].value;
	var hTo = $('#hTo')[0].value;
	var parameters = '?country=' + country;
	if(hFrom) parameters += '&hFrom=' + hFrom;
	if(hTo) parameters += '&hTo=' + hTo;
	var request = $.ajax({
	    type: 'Get',
	    url: '/Suche' + parameters
	});
	request.done(function(response) {
		$('#resultTable tr').not(':first').remove();
		var html = '';
		for(var i = 0; i < response.length; i++) {
	         html += '<tr>' +
	                 '<td>' + response[i].name + '</td>' +
	                 '<td>' + response[i].country + '</td>' +
	                 '<td>' + response[i].height + '</td>' +
	                 '</tr>';
		}
		$('#resultTable tr').first().after(html);
		$('#results').show();	
	});
}


$(function() {
  $( "#slider-hoehen" ).slider({
    range: true,
    min: 0,
    max: 8000,
    step:100,
    values: [ 0, 8000 ],
    slide: function( event, ui ) {
      $( "#hoehen" ).val(ui.values[ 0 ] + " m - " + ui.values[ 1 ] + " m" );
      $( "#hFrom").val(ui.values[ 0 ]);
      $( "#hTo").val(ui.values[ 1 ]);
    }
  });
  $( "#hoehen" ).val($( "#slider-hoehen" ).slider( "values", 0 ) + " m"  +
    " - " + $( "#slider-hoehen" ).slider( "values", 1 ) + " m" );
  $( "#hFrom").val($( "#slider-hoehen" ).slider( "values", 0 ));
  $( "#hTo").val($( "#slider-hoehen" ).slider( "values", 1 ));

});
$(function() {
  $( "#country" ).selectmenu({
	  width:200
  });
  $('#submit').button();
});
