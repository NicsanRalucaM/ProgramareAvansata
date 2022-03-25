package Laborator5;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException, InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyCat");
        var book = new Item("knuth67", "The Art of Computer Programming", "C:/Users/raluc/Downloads/The_Art_of_Computer_Programming - Vol 1.pdf");
        var article = new Item("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html");
        catalog.add(book);
        catalog.add(article);

        CatalogUtil.save(catalog, "D:/research/catalog.json");
    }

    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("D:/research/catalog.json");
        System.out.println(catalog);
    }

}
