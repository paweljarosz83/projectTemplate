$(document).ready(function() {
	
	$.fn.datepicker.defaults.language = 'pl';
    
    $(function () {
    	
    	//wniosekNowy
//        $("#dataPismaKlientaField").datepicker({
//        	 format: 'yyyy-mm-dd',
//        	 todayHighlight: true
//        });
//        
//        $("#dataWplywuPismaField").datepicker({
//       	 	format: 'yyyy-mm-dd',
//       	 	todayHighlight: true
//        });
//        
//        
//        
//        

        
        
        $(function () {
            
            $(".datepicker").datepicker({
           	 	format: 'yyyy-mm-dd',
           	 	todayHighlight: true,
            });
        });
        
        
        
        
//        
//        //wniosekDane
//        $(".datepickerdataWystawieniaWnioskuField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        $("#dataRozpoczeciaPostepowaniaField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        $("#dataZakonczeniaPostepowaniaField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        $("#dataDecyzjiOPrzyjeciuField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        //daneTransakcji.html
//        $("#dataFakturyField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        $("#dataFakturyEksportowejField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        $("#dataDokWZField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        $("#dataListuPrzewozowegoField").datepicker({
//           	 	format: 'dd/mm/yyyy',
//           	 	todayHighlight: true
//        });
//        
//        $("#dataPWPartiiField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        //daneIlosciowe
//        $("#gwarancjaOdDniaField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        //daneWalutowe
//        $("#dataPrzelicznikaField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        //korektaFaktury
//        $("#dataDokumentuKorygField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        //koszty reklamacji
//        $("#wuw_dataDokField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        $("#wuw_dataAkcpatacjiField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        $("#deb_dataDokField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        $("#deb_dataAkcpatacjiField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        $("#trans_dataDokField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        $("#trans_dataAkcpatacjiField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        $("#podr_dataDokField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        $("#podr_dataAkcpatacjiField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        $("#osob_dataDokField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        $("#osob_dataAkcpatacjiField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        $("#nwew_dataDokField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        $("#nwew_dataAkcpatacjiField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        
//        $("#nzew_dataDokField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        $("#nzew_dataAkcpatacjiField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        
//        //decyzja.html
//        $("#dataDecyzjiPelnomocnikaZarzaduDsUznaniaReklField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        $("#dataWyjasnieniaField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        //stanowisko.html
//        $("#dataPrzedstawieniaStanowiskaBHField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        $("#dataWykonaniaAnalizyBOK2Field").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        //uruchomienie.html
//        $("#dataUruchomieniaPostepowaniaField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        $("#wymaganyTerminZakonczeniaWyjasnienField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        
//        
//        //autorzyraportu.html
//        $("#dataOpracowaniaRaportuField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        $("#dataZatwierdzeniaRaportuField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        
//        //podjeteDzialania.html
//        $("#dataOcenyField").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        
//        
//        //dokumenty
//        
//        $(".dokDS").datepicker({
//       	 	format: 'dd/mm/yyyy',
//       	 	todayHighlight: true
//        });
//        
//        
//        
//        
//        
//        
//        
//        
//        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    });
});