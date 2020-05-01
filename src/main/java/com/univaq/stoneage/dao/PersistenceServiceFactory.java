package com.univaq.stoneage.dao;

/**
 * PersistenceServiceFactory is a singleton class responsible to get the right class DAO to interact with the DB.
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
     * Get the DAO class for the model class which simple name is passed by parameter.
     * If for model class does not exist the DAO class, it returns null.
     *
     * @param className String The simple name of the model class
     * @return The DAO class for a model class if exists, otherwise null
     */
    public IGenericDAO<?> getDao(String className) {
        IGenericDAO<?> genericDAO;
        switch (className) {
            case "MMarker": {
                genericDAO = new MarkerDAO();
                break;
            }
            case "MSquare": {
                genericDAO = new SquareDAO();
                break;
            }
            case "MTokenForest": {
                genericDAO = new TokenForestDAO();
                break;
            }
            case "MResource": {
                genericDAO = new ResourceDAO();
                break;
            }
            case "MHutToken": {
                genericDAO = new HutTokenDAO();
                break;
            }
            default:
                genericDAO = null;
        }
        return genericDAO;
    }

//
//    public IGenericDAO<?> getDao2(Class clazz) {
//        Object x = switch (clazz) {
//            case MMarker.class -> new MarkerDAO();
//            case MSquare.class -> new SquareDAO();
//            case MTokenForest.class -> new TokenForestDAO();
//        }
//        return (IGenericDAO<?>) x;
//    }

//    public IGenericDAO<?> getDao2(Class clazz) {
//        Object x = switch (clazz){
//            case MMarker.class -> new MarkerDAO();
//            case MSquare.class -> new SquareDAO();
//            case MTokenForest.class -> new TokenForestDAO();
//            default ->  new Object();
//        }
//        return x;
//    }


//        public IGenericDAO<?> getDao(Class<?> clazz) {
//    IGenericDAO<?>  dao = null;
//    try {
//        dao = (IGenericDAO<?>) clazz.getDeclaredConstructor().newInstance();
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//        return dao;
//}
}
