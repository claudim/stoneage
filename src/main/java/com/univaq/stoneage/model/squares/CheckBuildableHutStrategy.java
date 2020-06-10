package com.univaq.stoneage.model.squares;

import com.univaq.stoneage.model.MResource;
import com.univaq.stoneage.model.hutTokens.MHutToken;
import com.univaq.stoneage.model.players.MPlayer;
import com.univaq.stoneage.utility.TokenState;

import java.util.ArrayList;
import java.util.Map;

public class CheckBuildableHutStrategy implements ICheckBuildableHutStrategy {
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

                //todo il reset è da fare quando termina il turno un giocatore.
                //reset for the next active player
                //mHutToken.setM_buildableByActivePlayer(false);
            }
        }
        return playerBuildableMHutTokens;
    }
}
