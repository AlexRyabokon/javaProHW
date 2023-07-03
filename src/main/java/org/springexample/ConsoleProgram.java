package org.springexample;


import org.springexample.entites.Cart;
import org.springexample.entites.Product;
import org.springexample.repository.ProductRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;


public class ConsoleProgram {
    private static final Logger LOGGER = Logger.getLogger(ConsoleProgram.class.getName());

    public void startConsoleProgram(Cart cart, ProductRepository productRepository) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int choice;
            do {
                LOGGER.info("\u001B[32m" + "1. Add product to your cart" + "\u001B[0m");
                LOGGER.info("\u001B[32m" + "2. Delete product from your cart" + "\u001B[0m");
                LOGGER.info("\u001B[32m" + "3. Exit" + "\u001B[0m");
                LOGGER.info("\u001B[34m" + "Choice: " + "\u001B[0m");
                choice = Integer.parseInt(reader.readLine());

                switch (choice) {
                    case 1:
                        LOGGER.info("\u001B[32m" + "Input product ID for adding into the cart: " + "\u001B[0m");
                        long productIdToAdd = Long.parseLong(reader.readLine());
                        cart.addProd(productRepository.getById(productIdToAdd));
                        break;
                    case 2:
                        LOGGER.info("\u001B[32m" + "Input product ID for delete: " + "\u001B[0m");
                        long productIdToDelete = Long.parseLong(reader.readLine());
                        cart.deleteProdById(productIdToDelete);
                        break;
                    case 3:
                        LOGGER.info("Exit..........");
                        break;

                    default:
                        LOGGER.info("\u001B[34m" + "Choose 1, 2 or 3" + "\u001B[0m");
                }
                LOGGER.info("\u001B[34m"+ "Current cart: " + cart.getProducts() + "\u001B[0m");
                LOGGER.info("");
            } while (choice != 3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            throw new NullPointerException("There is no product with such id in repository");
        }
    }
}
