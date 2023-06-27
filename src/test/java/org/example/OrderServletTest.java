package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;


public class OrderServletTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    private OrderServlet orderServlet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        orderServlet = new OrderServlet();
    }

    @Test
    void testDoGet_WithValidOrderId() throws Exception {
        when(request.getPathInfo()).thenReturn("/1");

        orderServlet.doGet(request, response);

    }

    @Test
    void testDoGet_WithInvalidOrderId() throws Exception {
        when(request.getPathInfo()).thenReturn("/invalid");

        orderServlet.doGet(request, response);

    }

    @Test
    void testDoPost() throws Exception {
        when(request.getParameter("id")).thenReturn("1");
        when(request.getParameter("date")).thenReturn("2023-06-25");
        when(request.getParameter("cost")).thenReturn("10.0");
        when(request.getParameterValues("productIds")).thenReturn(new String[]{"1", "2"});
        when(request.getParameterValues("productNames")).thenReturn(new String[]{"Product 1", "Product 2"});
        when(request.getParameterValues("productCosts")).thenReturn(new String[]{"5.0", "7.0"});

        orderServlet.doPost(request, response);
    }

    @Test
    void testDoPut_WithValidOrderId() throws Exception {
        when(request.getPathInfo()).thenReturn("/1");
        when(request.getParameter("id")).thenReturn("1");
        when(request.getParameter("date")).thenReturn("2023-06-26");
        when(request.getParameter("cost")).thenReturn("15.0");
        when(request.getParameterValues("productIds")).thenReturn(new String[]{"1", "2"});
        when(request.getParameterValues("productNames")).thenReturn(new String[]{"Product 1", "Product 2"});
        when(request.getParameterValues("productCosts")).thenReturn(new String[]{"5.0", "7.0"});

        orderServlet.doPut(request, response);

    }

    @Test
    void testDoPut_WithInvalidOrderId() throws Exception {
        when(request.getPathInfo()).thenReturn("/invalid");
        orderServlet.doPut(request, response);

    }

    @Test
    void testDoDelete_WithValidOrderId() throws Exception {
        when(request.getPathInfo()).thenReturn("/1");
        orderServlet.doDelete(request, response);

    }

    @Test
    void testDoDelete_WithInvalidOrderId() throws Exception {
        when(request.getPathInfo()).thenReturn("/invalid");
        orderServlet.doDelete(request, response);

    }

}
