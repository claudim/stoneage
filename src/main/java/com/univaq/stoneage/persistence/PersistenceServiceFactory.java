package com.univaq.stoneage.persistence;

/**
 * PersistenceServiceFactory is a singleton class responsible to get the right persistence class to interact with the DB.
 */
public class PersistenceServiceFactory {

    /**
     * The PersistenceServiceFactory instance field
     */
    private static PersistenceServiceFactory instance;

    /**
     * Get the only one instance of this class if exists, otherwise it creates ones.
     *
     * @return the PersistenceServiceFactory instance
     */
    public static PersistenceServiceFactory getInstance() {
        if (instance == null) {
            instance = new PersistenceServiceFactory();
        }
        return instance;
    }

    /**
     * Get the persistence class for the model class which simple name is passed by parameter.
     * If for model class does not exist the persistence class, it returns null.
     *
     * @param className String The simple name of the model class
     * @return The persistence class for a model class if exists, otherwise null
     */
    public IPersistentGeneric<?> getPersistenceClass(String className, String nameMode) {
        IPersistentGeneric<?> persistentGeneric;
        switch (className) {
            case "MMarker": {
                persistentGeneric = new PMarker();
                break;
            }
            case "MSquare": {
                persistentGeneric = new PSquare();
                if (nameMode.equals("rossa")) {
                    persistentGeneric = new PRedSquare();
                }
                if (nameMode.equals("verde")) {
                    persistentGeneric = new PGreenSquare();
                }
                break;
            }
            case "MTokenForest": {
                persistentGeneric = new PTokenForest();
                if (nameMode.equals("rossa")) {
                    persistentGeneric = new PRedTokenForest();
                }
                if (nameMode.equals("verde")) {
                    persistentGeneric = new PGreenTokenForest();
                }
                break;
            }
            case "MResource": {
                persistentGeneric = new PResource();
                break;
            }
            case "MHutToken": {
                persistentGeneric = new PHutToken();
                break;
            }
            default:
                persistentGeneric = null;
        }
        return persistentGeneric;
    }
}
