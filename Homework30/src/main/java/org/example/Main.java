package org.example;

public class Main
{
    public static void main( String[] args )
    {
         ServerHW serverHW = new ServerHW();
         serverHW.start();

         ClientHW clientHW = new ClientHW();
         clientHW.start();
    }
}
