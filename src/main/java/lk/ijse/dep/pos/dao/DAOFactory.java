package lk.ijse.dep.pos.dao;

import lk.ijse.dep.pos.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.dep.pos.dao.custom.impl.ItemDAOImpl;
import lk.ijse.dep.pos.dao.custom.impl.OrderDAOImpl;
import lk.ijse.dep.pos.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.dep.pos.dao.custom.impl.QueryDAOImpl;

public class DAOFactory {

  private static DAOFactory daoFactory;

  private DAOFactory() {
  }

  public static DAOFactory getInstance() {
    return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
  }

  public <T extends SuperDAO> T getDAO(DAOType daoType) {
    switch (daoType) {
      case CUSTOMER:
        return (T) new CustomerDAOImpl();
      case ITEM:
        return (T) new ItemDAOImpl();
      case ORDER:
        return (T) new OrderDAOImpl();
      case ORDER_DETAIL:
        return (T) new OrderDetailDAOImpl();
      case QUERY:
        return (T) new QueryDAOImpl();
      default:
        return null;
    }
  }

/*  public CustomerDAO getCustomerDAO(){
    return new CustomerDAOImpl();
  }

  public ItemDAO getItemDAO(){
    return new ItemDAOImpl();
  }

  public OrderDAO getOrderDAO(){
    return new OrderDAOImpl();
  }

  public OrderDetailDAO getOrderDetailDAO(){
    return new OrderDetailDAOImpl();
  }*/
}
