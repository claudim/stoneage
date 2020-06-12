package com.univaq.stoneage.model.squares.buildingSiteSquare;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.hutTokens.MHutToken;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.utility.TokenState;

import java.util.ArrayList;
import java.util.Map;

/**
 * Strategy for the control of the buildable hut strategy according to resources and dog jolly resource.
 */
public class CheckBuildableHutStrategy implements ICheckBuildableHutStrategy {
    /**
     * Check if a list of hut tokens are buildable for the player according to the player resources and the dog resource(the jolly).
     *
     * @param player           The player who want to build a hut.
     * @param hutTokensToCheck The list of the all hut tokens not buildable yet
     * @return The hut token buildable
     */
    @Override
    public ArrayList<MHutToken> checkBuildableHut(MPlayer player, ArrayList<MHutToken> hutTokensToCheck) {
        ArrayList<MHutToken> playerBuildableMHutTokens = new ArrayList<>();
        int dogResourceNumber = player.getM_settlement().resourceTypeCounter("cane");

        //system checks if the player has enough resources to build an hut.
        for (MHutToken mHutToken : hutTokensToCheck) {
            if (mHutToken.getM_state().equals(TokenState.FACEUP)) {
                mHutToken.setM_buildableByActivePlayer(true);
                //posso costruire la capanna?
                Map<MResource, Integer> hutTokenMResources = mHutToken.getM_resources();
                int quanteRisorseMancano = 0;
                for (Map.Entry<MResource, Integer> entry : hutTokenMResources.entrySet()) {
                    MResource mResource = entry.getKey();
                    Integer resourceNumber = entry.getValue();
                    int i = resourceNumber - player.getM_settlement().resourceTypeCounter(mResource.getM_type());
                    if (i > 0)
                        quanteRisorseMancano += i;
                }
                if (dogResourceNumber < quanteRisorseMancano)
                    mHutToken.setM_buildableByActivePlayer(false);
                if (mHutToken.isM_buildableByActivePlayer())
                    playerBuildableMHutTokens.add(mHutToken);
            }
        }
        return playerBuildableMHutTokens;
    }
}
