package model;

public class PersonDataMapper implements Mapper {
    @Override
    public String map(PersonData personData) {
        return String.format
                (
                        "<%s><%s><%s><%s><%d><%s>\n",
                        personData.getFirstName(),
                        personData.getLastName(),
                        personData.getSurname(),
                        personData.getBirthDate(),
                        personData.getPhoneNumber(),
                        personData.getSex()
                );
    }
}
