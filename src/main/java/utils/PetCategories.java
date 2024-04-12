package utils;

public enum PetCategories {
	FISH("Fish"),
	CATS("Cats"),
	DOGS("Dogs"),
	REPTILES("Reptiles"),
	BIRDS("Birds");
	

private String value;

PetCategories(String value) {
	this.value=value;
}
//get string representation of enum

public String getValue() {
	return value;
}

}
