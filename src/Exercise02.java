import java.util.*;

public class Exercise02 {
    public static void main(String[] args) {

        Stock stock = new Stock();

        Product product = new Product();

        stock.addProduct(product);

        Product product2 = stock.findProductByIdentificationNumber(0);

        product2.updateProduct();

        System.out.println(product2);
    }
}

class Stock {
    public String name;
    private List<Product> products = new ArrayList<>();
    private int identificationNumber;
    private static int identificationNumberCounter;

    Stock() {
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

    void addProduct(Product product) {
        this.products.add(product);
    }

    Product findProductByIdentificationNumber(int productIdentificationNumber) {
        for (Product product : products) {
            if (product.getIdentificationNumber() == productIdentificationNumber) {
                return product;
            }
        }

        throw new IllegalArgumentException("produto não encontrado");
    }

    void deleteProduct(int identificationNumber) {
        for (Product product : products) {
            if (this.identificationNumber == identificationNumber) {
                products.remove(product);

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
    private int quantityInStock;
    private String brand;
    private int identificationNumber;
    private static int identificationNumberCounter;

    Product() {
        this.identificationNumber = identificationNumberCounter;

        identificationNumberCounter++;
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
