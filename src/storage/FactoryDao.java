package storage;


/**
 * La classe FactoryDAO costruisce un oggetto di tipo ObjectDAO.
 * Questa classe permette di creare un oggetto di tipo ObjectDAO specificando 
 quale tipo di DAO Ë in particolare.
 * @author Antonio Cimino
 * @version 1.0
 */

public class FactoryDao {
  /**
   * Il metodo serve per costruire un oggetto DAO di una particolare tipologia.
   * @return restituisce un oggetto DAO.
   */
  public ObjectDao getObject(String tipo) {
    ObjectDao o = null;
    switch (tipo) {
      case "Utente" :
        o = new UtenteDaoImp();
        break;
      case "Autorit‡" :
          o = new Autorit‡DaoImp();
          break;
      case "Segnalazione" :
    	  o = new SegnalazioneDaoImp();
    	  break;
      default:
        break;
    }
    return o;
  }
}