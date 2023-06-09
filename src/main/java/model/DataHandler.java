package model;

public class DataHandler implements Handler {
    private Mapper mapper;
    private Writable fileOperator;
    private final String stringPattern = "[А-Яа-яA-Za-z]*";

    public DataHandler(Mapper mapper, Writable fileOperator) {
        this.mapper = mapper;
        this.fileOperator = fileOperator;
    }

    @Override
    public boolean doYourJob(String input) throws Exception {
        String[] inputArray = splitInputString(input);
        checkInputTypes(inputArray);
        return passData(inputArray);
    }


    public String[] splitInputString(String input) throws Exception {
        String[] inputArray = input.split(" ");
        int DATA_SIZE = 6;
        if (inputArray.length != DATA_SIZE) {
            if (inputArray.length > DATA_SIZE) {
                throw new Exception("Вы ввели больше данных чем надо\n");
            } else {
                throw new Exception("Вы ввели меньше данных чем надо\n");
            }
        } else {
            return inputArray;
        }
    }

    public boolean checkInputTypes(String[] inputArray) throws Exception {
        return checkFirstName(inputArray[0]) && checkLastName(inputArray[1])
                && checkSurName(inputArray[2]) && checkDateBirth(inputArray[3])
                && checkPhoneNumber(inputArray[4]) && checkSex(inputArray[5]);

    }

    private boolean checkFirstName(String firstName) throws Exception {
        if (firstName.matches(stringPattern)) {
            return true;
        } else {
            throw new Exception("В имени есть небуквенные символы\n");
        }
    }

    private boolean checkLastName(String lastName) throws Exception {
        if (lastName.matches(stringPattern)) {
            return true;
        } else {
            throw new Exception("В фамилии есть небуквенные символы\n");
        }
    }

    private boolean checkSurName(String surName) throws Exception {
        if (surName.matches(stringPattern)) {
            return true;
        } else {
            throw new Exception("В отчестве есть небуквенные символы\n");
        }
    }

    private boolean checkDateBirth(String dateBirth) throws Exception {
        String dateBirthPattern = "\\d{2}.\\d{2}.\\d{4}";
        if (dateBirth.matches(dateBirthPattern)) {
            return true;
        } else {
            throw new Exception("Неправильный формат даты\n");
        }
    }

    private boolean checkPhoneNumber(String phoneNumber) throws Exception {
        String phoneNumberPattern = "\\d*";
        if (phoneNumber.matches(phoneNumberPattern)) {
            return true;
        } else {
            throw new Exception("Неправильный формат номера\n");
        }
    }

    private boolean checkSex(String sex) throws Exception {
        if (sex.equals("f") || sex.equals("m")) {
            return true;
        } else {
            throw new Exception("Неправильный формат пола\n");
        }
    }

    private boolean passData(String[] data) throws Exception {
        PersonData personData = new PersonData
                (
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        Long.parseLong(data[4]),
                        data[5]
                );
        return fileOperator.writeInFile(mapper.map(personData), personData.getFirstName());
    }


}
