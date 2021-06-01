package eTrade.business.concretes;

import eTrade.core.abstracts.ExternalServiceSignIn;
import eTrade.googleSessionAssistant.GoogleSignInManager;

public class GoogleSessionAssistantAdapter implements ExternalServiceSignIn {

	@Override
	public void addWithExternalService(String message) {

		GoogleSignInManager signInManager = new GoogleSignInManager();
		signInManager.signIn(message);
	}

}
