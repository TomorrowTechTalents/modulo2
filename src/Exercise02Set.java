import java.util.Set;
import java.util.Scanner;
import java.util.LinkedHashSet;

enum Options {
    RENAME_STOCK,
    REGISTER_PRODUCT,
    CHECK_PRODUCT,
    UPDATE_PRODUCT,
    DELETE_PRODUCT,
    LIST_PRODUCTS,
    EXIT
}

public class Exercise02Set {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("cadastre um estoque");
        System.out.print("nome: ");
        String stockName = scanner.nextLine();
        StockSet stock = new StockSet(stockName);
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

            Options option = Options.values()[scanner.nextByte() - 1];
            scanner.nextLine();

            switch (option) {
                case RENAME_STOCK:
                    System.out.print("novo nome: ");
                    stock.name = scanner.nextLine();
                    System.out.println("Estoque renomeado com sucesso.");
                    break;
                case REGISTER_PRODUCT:
                    ProductSet productToAdd = new ProductSet();
                    stock.addProduct(productToAdd);
                    break;
                case CHECK_PRODUCT:
                    System.out.print("identificador do produto com dados a exibir: ");
                    ProductSet productToCheck = stock.findProductByIdentificationNumber();
                    System.out.println(productToCheck);
                    break;
                case UPDATE_PRODUCT:
                    System.out.print("identificador do produto com dados a editar: ");
                    ProductSet productToUpdate = stock.findProductByIdentificationNumber();
                    productToUpdate.updateProduct();
                    break;
                case DELETE_PRODUCT:
                    System.out.print("identificador do produto a ser removido: ");
                    ProductSet productToRemove = stock.findProductByIdentificationNumber();
                    stock.deleteProduct(productToRemove);
                    break;
                case LIST_PRODUCTS:
                    stock.listProducts();
                    break;
                case EXIT:
                    System.out.println("até mais");
                    return;
                default:
                    throw new IllegalArgumentException("opção inválida");
            }

            System.out.println();
        }
    }
}

class StockSet {
    public String name;
    private final Set<ProductSet> products = new LinkedHashSet<>();
    private static int identificationNumberCounter;

    StockSet(String name) {
        this.name = name;

        int identificationNumber = identificationNumberCounter;

        identificationNumberCounter++;
    }

    void addProduct(ProductSet newProduct) {
        this.products.add(newProduct);
    }

    ProductSet findProductByIdentificationNumber() {
        Scanner scanner = new Scanner(System.in);

        int productIdentificationNumber = scanner.nextInt();

        for (ProductSet product : this.products) {
            if (product.getIdentificationNumber() == productIdentificationNumber) {
                return product;
            }
        }

        throw new IllegalArgumentException("produto não encontrado");
    }

    void deleteProduct(ProductSet productToRemove) {
        for (ProductSet product : this.products) {
            if (product == productToRemove) { // equals()? Object.equals()?
                this.products.remove(product);

                break;
            }
        }
    }

    void listProducts() {
        for (ProductSet product : this.products) {
            System.out.println(product);
        }
    }
}

class ProductSet {
    private String name;
    private String department;
    private String type;
    private double quantityInStock;
    private String brand;
    private final int identificationNumber;
    private static int identificationNumberCounter;

    ProductSet() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("nome: ");
        this.name = scanner.nextLine();

        System.out.print("seção: ");
        this.department = scanner.nextLine();

        System.out.print("tipo: ");
        this.type = scanner.nextLine();

        System.out.print("quantidade em estoque: ");
        this.quantityInStock = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("marca: ");
        this.brand = scanner.nextLine();

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
        this.quantityInStock = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("nova marca (a marca antiga é " + this.brand + "): ");
        this.brand = scanner.nextLine();
    }

    void addQuantitiesInStock(ProductSet product) {
        this.quantityInStock += product.quantityInStock;
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() == obj.getClass()) {
            ProductSet product = (ProductSet) obj;

            if (this.name.equals(product.name) && this.brand.equals(product.brand)) {
                product.addQuantitiesInStock(this);

                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() * this.brand.hashCode();
    }

    @Override
    public String toString() {
        return "Produto = {nome: " + this.name + ", seção: " + this.department + ", tipo: " + this.type +
                         ", quantidade em estoque: " + this.quantityInStock + ", marca: " + this.brand +
                         ", identificador: " + this.identificationNumber + "}";
    }
}
