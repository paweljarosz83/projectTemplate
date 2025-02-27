/**
 * 
 */

$(document).ready(function() {
	
	
	$("#sapIdInputField").autocomplete({
		source : '/surowce/auto',
		response: function(e,ui) {
			
			enableSurowiecFormFields();
			cleanSurowiecFormFields();
		},
		select: function(e, ui){
			loadSurowiec(ui.item.label);
			cleanErrors();
		},
	});
	
	$("#sapIdInputField").focusout(function() {
		  var sapID =  $("#sapIdInputField").val();
		  loadSurowiec(sapID);
	});
	
});


function enableSurowiecFormFields(){
	$('#nazwaPLInputField').prop("disabled", false);
	$('#nazwaENInputField').prop("disabled", false);
	$('#grupaMaterialowaInputField').prop("disabled", false);
	$('#zakladyInput').prop("disabled", false);
	
	$('#checktf01').prop("disabled", false);
	$('#checktf02').prop("disabled", false);
	$('#checktf03').prop("disabled", false);
	$('#checktf05').prop("disabled", false);
	
}

function cleanSurowiecFormFields(){
	$('#nazwaPLInputField').val("");
	$('#nazwaENInputField').val("");
	$('#grupaMaterialowaInputField').val("");
	$("#zakladyInput").val("");
	$('#checktf01').prop("checked", false);
	$('#checktf02').prop("checked", false);
	$('#checktf03').prop("checked", false);
	$('#checktf05').prop("checked", false);
}


function loadSurowiec(sapID){
	
	console.log("load s " +sapID);
	
	$.ajax({
		url:'/surowiec',
		data:{
			'sapID':sapID
		},
		success: function(surowiecDTO){
			
			console.log("sdto "+ surowiecDTO);

			if(surowiecDTO === null || surowiecDTO === ""){
				console.log("a");
				//$('#nazwaPLInputField').prop("disabled", false);
				//$('#nazwaENInputField').prop("disabled", false);
				//$('#grupaMaterialowaInputField').prop("disabled", false);
				//$('#zakladyInput').prop("disabled", false);

			}else{
				console.log("b");
				$("#nazwaPLInputField").val(surowiecDTO.nazwaPL);
				$('#nazwaPLInputField').prop("disabled", true);

				$("#nazwaENInputField").val(surowiecDTO.nazwaEN);
				$('#nazwaENInputField').prop("disabled", true);

				$("#grupaMaterialowaInputField").val(surowiecDTO.grupaMaterialowa);
				$('#grupaMaterialowaInputField').prop("disabled", true);
				
				$("#zakladyInput").val(surowiecDTO.zaklady);
				$('#zakladyInput').prop("disabled", true);
				
				console.log(surowiecDTO.zaklady);
				
				if(surowiecDTO.zaklady.includes("TF01")){
					$('#checktf01').prop("checked", true);
					$('#checktf01').prop("disabled", true);
				}else{
					$('#checktf01').prop("disabled", true);
				}
				
				if(surowiecDTO.zaklady.includes("TF02")){
					$('#checktf02').prop("checked", true);
					$('#checktf02').prop("disabled", true);
				}else{
					$('#checktf02').prop("disabled", true);
				}
				
				if(surowiecDTO.zaklady.includes("TF03")){
					$('#checktf03').prop("checked", true);
					$('#checktf03').prop("disabled", true);
				}else{
					$('#checktf03').prop("disabled", true);
				}
				
				if(surowiecDTO.zaklady.includes("TF05")){
					$('#checktf05').prop("checked", true);
					$('#checktf05').prop("disabled", true);
				}else{
					$('#checktf05').prop("disabled", true);
				}
			}
		}
	})
}

function  cleanErrors(){
	$("#sapIdInputFieldError").text("");
	$("#nazwaPLInputFieldError").text("");
	$("#nazwaENInputFieldError").text("");
	$("#grupaMaterialowaInputFieldError").text("");
}



