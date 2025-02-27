/**
 * 
 */

$(document).ready(function() {
	
	/*
	$("#sapIdInputField").autocomplete({
		source : '/surowce/auto',
		select: function(e, ui){
			loadSurowiec(ui.item.label);
			cleanErrors();
		},
	});

	$("#sapIdInputField").keyup(function(){
		var sapIDText = $("#sapIdInputField").val();
		loadSurowiec(sapIDText);
		cleanErrors();
	});
	*/
	
});


function loadSurowiec(sapID){
	$.ajax({
		url:'/surowiec',
		data:{
			'sapID':sapID
		},
		success: function(surowiecDTO){

			if(surowiecDTO === ""){

				$('#nazwaPLInputField').prop("disabled", false);
				$('#nazwaENInputField').prop("disabled", false);
				$('#grupaMaterialowaInputField').prop("disabled", false);

				//$('#zakladSelectField').prop("disabled", true);
			}else{
				$("#nazwaPLInputField").val(surowiecDTO.nazwaPL);
				$('#nazwaPLInputField').prop("disabled", true);

				$("#nazwaENInputField").val(surowiecDTO.nazwaEN);
				$('#nazwaENInputField').prop("disabled", true);

				$("#grupaMaterialowaInputField").val(surowiecDTO.grupaMaterialowa);
				$('#grupaMaterialowaInputField').prop("disabled", true);

				//$('#zakladSelectField').prop("disabled", true);
				//$("#zakladSelectField").val("");
			}
			//$("#zakladSelectField").val(surowiecDTO.zaklad).change();
		}
	})
}

function  cleanErrors(){
	$("#sapIdInputFieldError").text("");
	$("#nazwaPLInputFieldError").text("");
	$("#nazwaENInputFieldError").text("");
	$("#grupaMaterialowaInputFieldError").text("");
}



