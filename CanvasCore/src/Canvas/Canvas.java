/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Canvas;

import Util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Rosana
 */
public class Canvas {

    public static void main(String[] args) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
    }

}