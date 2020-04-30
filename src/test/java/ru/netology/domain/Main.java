package ru.netology.domain;

import ru.netology.repository.ProductRepository;

public class Main {
    public static void main(String[] args) {


        try {
            System.out.println("before remove");
            ProductRepository.removeById();
            System.out.println("after remove");
        } catch (
                RuntimeException e) {
            System.out.println("runtime catch");
        } catch (
                Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }

        try {
            System.out.println("before remove");
            ProductRepository.removeById();
            System.out.println("after remove");
        } catch (
                Throwable e) {

        }
    }
}
