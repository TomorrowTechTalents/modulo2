package exercise02;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Exercise02List {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("cadastre um estoque");
        System.out.print("nome: ");
        String stockName = scanner.nextLine();
        Stock stock = new Stock(stockName);
        System.out.println();

        while (true) {
            System.out.println("** estoque " + stock.name + " **");
            System.out.println("escolha uma opção:");
            System.out.println("1 - renomear o estoque");
            System.out.println("2 - cadastrar novo produto");
            System.out.println("3 - ver detalhes de um produto");
            System.out.println("4 - editar dados de um produto");
            System.out.println("5 - remover produto");
            System.out.println("6 - listar produtos");
            System.out.println("7 - sair");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("novo nome: ");
                    stock.name = scanner.nextLine();
                    System.out.println("Estoque renomeado com sucesso.");
                    break;
                case 2:
                    Product productToAdd = Product.buildProductFromUserInput();
                    Product product = stock.findProductWithSameNameAndBrandAlreadyPresent(productToAdd);

                    if (product == null) {
                        stock.addProduct(productToAdd);

                        break;
                    }

                    product.addQuantitiesInStock(productToAdd);
                    break;
                case 3:
                    System.out.print("identificador do produto com dados a exibir: ");
                    Product productToCheck = stock.findProductByIdentificationNumber();
                    System.out.println(productToCheck);
                    break;
                case 4:
                    System.out.print("identificador do produto com dados a editar: ");
                    Product productToUpdate = stock.findProductByIdentificationNumber();
                    stock.deleteProduct(productToUpdate);
                    productToUpdate.updateProduct();
                    product = stock.findProductWithSameNameAndBrandAlreadyPresent(productToUpdate);

                    if (product == null) {
                        stock.addProduct(productToUpdate);

                        break;
                    }


                    product.addQuantitiesInStock(productToUpdate);
                    break;
                case 5:
                    System.out.print("identificador do produto a ser removido: ");
                    Product productToRemove = stock.findProductByIdentificationNumber();
                    stock.deleteProduct(productToRemove);
                    break;
                case 6:
                    stock.listProducts();
                    break;
                case 7:
                    System.out.println("até mais");
                    return;
                default:
                    throw new IllegalArgumentException("opção inválida");
            }

            System.out.println();
        }
    }
}

class Stock {
    public String name;
    private List<Product> products = new ArrayList<>();
    private int identificationNumber;
    private static int identificationNumberCounter;

    Stock(String name) {
        this.name = name;
        this.identificationNumber = identificationNumberCounter;

        identificationNumberCounter++;
    }

    Product findProductWithSameNameAndBrandAlreadyPresent(Product newProduct) {
        for (Product product : this.products) {
            if (product.haveSameNameAndBrand(newProduct)) {
                return product;
            }
        }

        return null;
    }

    void addProduct(Product newProduct) {
        this.products.add(newProduct);
    }

    Product findProductByIdentificationNumber() {
        Scanner scanner = new Scanner(System.in);

        int productIdentificationNumber = scanner.nextInt();

        for (Product product : this.products) {
            if (product.getIdentificationNumber() == productIdentificationNumber) {
                return product;
            }
        }

        throw new IllegalArgumentException("produto não encontrado");
    }

    void deleteProduct(Product productToRemove) {
        for (Product product : this.products) {
            if (product == productToRemove) { // equals()? Object.equals()?
                this.products.remove(product);

                break;
            }
        }
    }

    void listProducts() {
        for (Product product : this.products) {
            System.out.println(product);
        }
    }
}

class Product {
    private String name;
    private String department;
    private String type;
    private double quantityInStock;
    private String brand;
    private int identificationNumber;
    private static int identificationNumberCounter;

    Product(String name, String department, String type, double quantityInStock, String brand) {
        this.name = name;
        this.department = department;
        this.type = type;
        this.quantityInStock = quantityInStock;
        this.brand = brand;
        this.identificationNumber = identificationNumberCounter;

        identificationNumberCounter++;
    }

    static Product buildProductFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("nome: ");
        String name = scanner.nextLine();

        System.out.print("seção: ");
        String department = scanner.nextLine();

        System.out.print("tipo: ");
        String type = scanner.nextLine();

        System.out.print("quantidade em estoque: ");
        double quantityInStock = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("marca: ");
        String brand = scanner.nextLine();

        Product product = new Product(name, department, type, quantityInStock, brand);

        return product;
    }

    int getIdentificationNumber() {
        return this.identificationNumber;
    }

    void updateProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("novo nome (o nome antigo é " + this.name + "): ");
        this.name = scanner.nextLine();

        System.out.print("nova seção (a seção antiga é " + this.department + "): ");
        this.department = scanner.nextLine();

        System.out.print("novo tipo (o tipo antigo é " + this.type + "): ");
        this.type = scanner.nextLine();

        System.out.print("nova quantidade em estoque (a quantidade antiga é " + this.quantityInStock + "): ");
        this.quantityInStock = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("nova marca (a marca antiga é " + this.brand + "): ");
        this.brand = scanner.nextLine();
    }

    boolean haveSameNameAndBrand(Product product) {
        return this.name.equals(product.name) && this.brand.equals(product.brand);
    }

    void addQuantitiesInStock(Product product) {
        this.quantityInStock += product.quantityInStock;
    }

    @Override
    public String toString() {
        return "Produto = {nome: " + this.name + ", seção: " + this.department + ", tipo: " + this.type +
                         ", quantidade em estoque: " + this.quantityInStock + ", marca: " + this.brand +
                         ", identificador: " + this.identificationNumber + "}";
    }
}
