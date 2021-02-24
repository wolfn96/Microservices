package com.example.gateway.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
// Beispiel eines Filters, wie er bei einem Zuul-Proxy zum Einsatz kommen kann
public class StandardFilter extends ZuulFilter {

    // Logger, um wichtige Informationen auf der Konsole auszugeben
    private static Logger log = LoggerFactory.getLogger(StandardFilter.class);

    // Wird überschrieben, um anzugeben, dass der Filter vor dem Routing angewandt werden soll
    @Override
    public String filterType(){
        return "pre";
    }

    // Hilft bei der Priorisierung
    @Override
    public int filterOrder(){
        return 1;
    }

    // Setzt den Filter aktiv ein
    @Override
    public boolean shouldFilter(){
        return true;
    }

    // Führt den Filter aus
    @Override
    public Object run(){
    RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request to %s",request.getMethod(),request.getRequestURL().toString()));
        return null;
    }

}
