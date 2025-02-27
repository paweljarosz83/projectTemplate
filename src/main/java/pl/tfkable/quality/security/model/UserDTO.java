package pl.tfkable.quality.security.model;

public class UserDTO {
	
	private Long id;

	
	
	private String numerAkt;
	private String miejsce;
	private String nazwisko;
	private String imie;
	private String zaklad;
	
	private String indeksZakladu;
	private String indeksKomorki;
	private String komorka;
	
	private String stanowisko;
	private String username;
	private String email;
	private String tel;
	private String mobile;
	private String password;
	
    //na tej podtswie tworzy role, nie zapisuje tego do encji
	private Boolean tworzyWniosek;
	private Boolean widziWniosek;
	
	private Boolean tworzyRaport;
	private Boolean widziRaport;
	
	private Boolean tworzyKoszty;
	private Boolean widziKoszty;
	
	private Boolean tworzyPostepowanie;
	private Boolean widziPostepowanie;

	private Boolean tworzySprawozdanie;
	

	
	
	private Boolean odpowiedzialny;
	private Boolean opracowujePostepowanie;
	private Boolean proponujeStanowiskoBhp;
	private Boolean pelnomocnikZarzadu;
	private Boolean dyrektor;
	private Boolean opracowujeRaport;
	private Boolean ocenyRaportuDokonal;
	
	
	
	
	
	

	
	
	
	private String rola;

	
	//na outpt do tabelki
	private String roles;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}



	public String getMiejsce() {
		return miejsce;
	}

	public void setMiejsce(String miejsce) {
		this.miejsce = miejsce;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getStanowisko() {
		return stanowisko;
	}

	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}

	public String getZaklad() {
		return zaklad;
	}

	public void setZaklad(String zaklad) {
		this.zaklad = zaklad;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

//	public Boolean getObslugujacy() {
//		return obslugujacy;
//	}
//
//	public void setObslugujacy(Boolean obslugujacy) {
//		this.obslugujacy = obslugujacy;
//	}
//
//	public Boolean getObserwator() {
//		return obserwator;
//	}
//
//	public void setObserwator(Boolean obserwator) {
//		this.obserwator = obserwator;
//	}
//
//	public Boolean getZatwierdzajacy() {
//		return zatwierdzajacy;
//	}
//
//	public void setZatwierdzajacy(Boolean zatwierdzajacy) {
//		this.zatwierdzajacy = zatwierdzajacy;
//	}
//	
//	public Boolean getAdmin() {
//		return admin;
//	}
//
//	public void setAdmin(Boolean admin) {
//		this.admin = admin;
//	}
//
//	public Boolean getZaglaszajcy() {
//		return zaglaszajcy;
//	}
//
//	public void setZaglaszajcy(Boolean zaglaszajcy) {
//		this.zaglaszajcy = zaglaszajcy;
//	}

	public String getRola() {
		return rola;
	}

	public void setRola(String rola) {
		this.rola = rola;
	}

	

	public Boolean getTworzyWniosek() {
		return tworzyWniosek;
	}

	public void setTworzyWniosek(Boolean tworzyWniosek) {
		this.tworzyWniosek = tworzyWniosek;
	}

	public Boolean getWidziWniosek() {
		return widziWniosek;
	}

	public void setWidziWniosek(Boolean widziWniosek) {
		this.widziWniosek = widziWniosek;
	}

	public Boolean getTworzyRaport() {
		return tworzyRaport;
	}

	public void setTworzyRaport(Boolean tworzyRaport) {
		this.tworzyRaport = tworzyRaport;
	}

	public Boolean getWidziRaport() {
		return widziRaport;
	}

	public void setWidziRaport(Boolean widziRaport) {
		this.widziRaport = widziRaport;
	}

	public Boolean getTworzyKoszty() {
		return tworzyKoszty;
	}

	public void setTworzyKoszty(Boolean tworzyKoszty) {
		this.tworzyKoszty = tworzyKoszty;
	}

	public Boolean getWidziKoszty() {
		return widziKoszty;
	}

	public void setWidziKoszty(Boolean widziKoszty) {
		this.widziKoszty = widziKoszty;
	}

	public Boolean getTworzyPostepowanie() {
		return tworzyPostepowanie;
	}

	public void setTworzyPostepowanie(Boolean tworzyPostepowanie) {
		this.tworzyPostepowanie = tworzyPostepowanie;
	}

	public Boolean getWidziPostepowanie() {
		return widziPostepowanie;
	}

	public void setWidziPostepowanie(Boolean widziPostepowanie) {
		this.widziPostepowanie = widziPostepowanie;
	}

	public Boolean getOdpowiedzialny() {
		return odpowiedzialny;
	}

	public void setOdpowiedzialny(Boolean odpowiedzialny) {
		this.odpowiedzialny = odpowiedzialny;
	}

	public Boolean getOpracowujePostepowanie() {
		return opracowujePostepowanie;
	}

	public void setOpracowujePostepowanie(Boolean opracowujePostepowanie) {
		this.opracowujePostepowanie = opracowujePostepowanie;
	}

	public Boolean getProponujeStanowiskoBhp() {
		return proponujeStanowiskoBhp;
	}

	public void setProponujeStanowiskoBhp(Boolean proponujeStanowiskoBhp) {
		this.proponujeStanowiskoBhp = proponujeStanowiskoBhp;
	}

	public Boolean getPelnomocnikZarzadu() {
		return pelnomocnikZarzadu;
	}

	public void setPelnomocnikZarzadu(Boolean pelnomocnikZarzadu) {
		this.pelnomocnikZarzadu = pelnomocnikZarzadu;
	}

	public Boolean getDyrektor() {
		return dyrektor;
	}

	public void setDyrektor(Boolean dyrektor) {
		this.dyrektor = dyrektor;
	}

	public Boolean getOpracowujeRaport() {
		return opracowujeRaport;
	}

	public void setOpracowujeRaport(Boolean opracowujeRaport) {
		this.opracowujeRaport = opracowujeRaport;
	}

	public Boolean getOcenyRaportuDokonal() {
		return ocenyRaportuDokonal;
	}

	public void setOcenyRaportuDokonal(Boolean ocenyRaportuDokonal) {
		this.ocenyRaportuDokonal = ocenyRaportuDokonal;
	}

	public String getNumerAkt() {
		return numerAkt;
	}

	public void setNumerAkt(String numerAkt) {
		this.numerAkt = numerAkt;
	}

	public String getIndeksZakladu() {
		return indeksZakladu;
	}

	public void setIndeksZakladu(String indeksZakladu) {
		this.indeksZakladu = indeksZakladu;
	}

	public String getIndeksKomorki() {
		return indeksKomorki;
	}

	public void setIndeksKomorki(String indeksKomorki) {
		this.indeksKomorki = indeksKomorki;
	}

	public String getKomorka() {
		return komorka;
	}

	public void setKomorka(String komorka) {
		this.komorka = komorka;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Boolean getTworzySprawozdanie() {
		return tworzySprawozdanie;
	}

	public void setTworzySprawozdanie(Boolean tworzySprawozdanie) {
		this.tworzySprawozdanie = tworzySprawozdanie;
	}

	
	
	
	
	
	
	
	

}
