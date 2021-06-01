package eTrade.googleSessionAssistant;

public class GoogleSignInManager implements GoogleSignInService {

	@Override
	public void signIn(String signInMessage) {

		System.out.println("Google ile giriþ yapýldý. " + signInMessage);

	}
}
