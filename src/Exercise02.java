import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Stock> stocks = new ArrayList<>();

        System.out.println("cadastre um estoque:");
        System.out.print("nome: ");
        String name = scanner.nextLine();
        Stock stock = new Stock(name);
        stocks.add(stock);


        while (true) {
            System.out.println("escolha uma opção:");
            System.out.println("1 - cadastrar novo estoque");
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
                    System.out.print("nome: ");
                    String newStockName = scanner.nextLine();
                    Stock newStock = new Stock(newStockName);
                    stocks.add(newStock);
                    System.out.println("Estoque cadastrado com sucesso.");
                    break;
                case 2:
                    Product productToAdd = new Product("name1", "seção1", "tipo1", 1, "marca1");
                    stocks.get(0).addProduct(productToAdd);
                    break;
                case 3:
                    Product product = stocks.get(0).findProductByIdentificationNumber(1);
                    System.out.println(product);
                    break;
                case 4:
                    Product productToUpdate = stocks.get(0).findProductByIdentificationNumber(1);
                    productToUpdate.updateProduct();
                    break;
                case 5:
                    stocks.get(0).deleteProduct(1);
                    break;
                case 6:
                    try {
                        stocks.get(0).listProducts();
                    } catch (Exception exception) {
                        System.out.println("Ocorreu um erro. Certifique-se de ter cadastrado um estoque.");
                    }
                    break;
                case 7:
                    System.out.println("até mais");
                    return;
                default:
                    throw new IllegalArgumentException("opção inválida");
            }
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

    int getIdentificationNumber() {
        return this.identificationNumber;
    }

    List<?> getProducts() {
        return products;
    }

    void setProducts() {
        // ?
    }

    void addProduct(Product newProduct) {
        for (Product product : this.products) {
            boolean haveSameNameAndBrand = newProduct.getName().equals(product.getName()) &&
                                           newProduct.getBrand().equals(product.getBrand());

            if (haveSameNameAndBrand) {
                product.setQuantityInStock(product.getQuantityInStock() + newProduct.getQuantityInStock());

                return;
            }
        }

        this.products.add(newProduct);
    }

    Product findProductByIdentificationNumber(int productIdentificationNumber) {
        for (Product product : products) {
            if (product.getIdentificationNumber() == productIdentificationNumber) {
                return product;
            }
        }

        throw new IllegalArgumentException("produto não encontrado");
    }

    void deleteProduct(int productIdentificationNumber) {
        for (Product product : this.products) {
            if (product.getIdentificationNumber() == productIdentificationNumber) {
                this.products.remove(product);

                break;
            }
        }
    }

    void listProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    void checkProductByIdentificationNumber(int identificationNumber) {
        for (Product product : products) {
            if (this.identificationNumber == identificationNumber) {
                System.out.println(product);
            }
        }
    }
}

class Product {
    private String name;
    private String department;
    private String type;
    private int quantityInStock; // maybe double for things given in kg for example?
    private String brand;
    private int identificationNumber;
    private static int identificationNumberCounter;

    Product(String name, String department, String type, int quantityInStock, String brand) {
        this.name = name;
        this.department = department;
        this.type = type;
        this.quantityInStock = quantityInStock;
        this.brand = brand;
        this.identificationNumber = identificationNumberCounter;

        identificationNumberCounter++;
    }

    String getName() {
        return this.name;
    }

    int getQuantityInStock() {
        return this.quantityInStock;
    }

    void setQuantityInStock(int quantity) {
        this.quantityInStock = quantity;
    }

    String getBrand() {
        return this.brand;
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
        this.quantityInStock = scanner.nextInt();
        scanner.nextLine();

        System.out.print("nova marca (a marca antiga é " + this.brand + "): ");
        this.brand = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Produto [nome=" + this.name + ", seção=" + this.department + ", tipo=" + this.type +
                         ", quantidade em estoque=" + this.quantityInStock + ", marca=" + this.brand +
                         ", identificador=" + this.identificationNumber + "]";
    }
}
