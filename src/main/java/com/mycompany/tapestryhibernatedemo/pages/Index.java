package com.mycompany.tapestryhibernatedemo.pages;


import com.mycompany.tapestryhibernatedemo.entities.Avion;
import com.mycompany.tapestryhibernatedemo.dao.AvionDao;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.InjectPage;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.HttpError;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;
import org.slf4j.Logger;

import java.util.Date;


/**
 * Start page of application TapestryHibernateDemo.
 */
public class Index
{
  @Inject
  private Logger logger;

  @Inject
  private AjaxResponseRenderer ajaxResponseRenderer;

  @Property
  @Inject
  @Symbol(SymbolConstants.TAPESTRY_VERSION)
  private String tapestryVersion;

  @InjectPage
  private About about;

  @Inject
  private Block block;
  



  // Handle call with an unwanted context
  Object onActivate(EventContext eventContext)
  {
    return eventContext.getCount() > 0 ?
        new HttpError(404, "Resource not found") :
        null;
  }

 

  public Date getCurrentTime()
  {
    return new Date();
  }
}
