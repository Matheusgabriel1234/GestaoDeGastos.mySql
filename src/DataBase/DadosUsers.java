package DataBase;

public class DadosUsers {
	private static final int MIN_ID = 100000; // Valor mínimo para o ID
    private static final int MAX_ID = 999999; // Valor máximo para o ID

    public static int generateRandomId() {
        Random random = new Random();
        return random.nextInt(MAX_ID - MIN_ID + 1) + MIN_ID;
    }


}
