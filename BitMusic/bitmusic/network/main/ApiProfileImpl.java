/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bitmusic.network.main;

import bitmusic.network.api.ApiProfile;
import bitmusic.network.exception.NetworkException;
import bitmusic.network.message.EnumTypeMessage;
import bitmusic.network.message.MessageGetUser;

/**
 *
 * @author florian
 */
public final class ApiProfileImpl implements ApiProfile {
    /**
    * Singleton implementation.
    */
    private static final ApiProfileImpl APIPROFILEHMI = new ApiProfileImpl();

    /**
     * Private constructor for singleton pattern.
     */
    private ApiProfileImpl() { }

    /**
     * .
     * @return Unique instance of ApiProfileImpl
     */
    protected static ApiProfileImpl getInstance() {
        return APIPROFILEHMI;
    }

    /*########################################################################*/
    /* IMPLEMENTED METHODS */
    /*########################################################################*/
    /**
     * Get the profile of a distant user.
     *
     * @param operator the id of the asking user.
     * @param userId the id of the user whose profile we want.
     * @throws NetworkException throws an exception when the given idUser isn't
     * in the directory
    */
    @Override
    public void getUser(final String operator, final String userId,
            final String searchId) throws NetworkException {
        //Get the source address
        //Warning, it may emmit an exception thrown to the calling method!
        final String sourceAddress = Controller.getNetworkAddress();

        //Get the remote address
        //Warning, it may emmit an exception thrown to the calling method!
        final String destAddress = Controller.getInstance().
                getUserIpFromDirectory(userId);

        //Construct the message
        final MessageGetUser message = new MessageGetUser(
                EnumTypeMessage.GetUser,
                sourceAddress,
                destAddress,
                operator,
                userId,
                searchId);

        Controller.getInstance().getThreadManager().assignTaskToHermes(message);
    }

    
}
