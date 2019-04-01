import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.drools.core.rule.Package;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    //    private final String ruleFile = "C:\\Users\\aldo.lushkja\\Desktop\\WORKSPACE\\DroolsTest\\src\\main\\resources\\Rule.drl";
    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, DroolsParserException {
        Main droolTest = new Main();
        droolTest.executeDrools();
    }

    private void executeDrools() throws IOException, DroolsParserException {

        // Drools inizializzazione
//        PackageBuilder packageBuilder = new PackageBuilder();
//
//        Path path = Paths.get(ruleFile);
//
//        InputStream resourceAsStream = getClass().getResourceAsStream(path.toString());
//
//        Reader reader = new InputStreamReader(resourceAsStream);
//
//        packageBuilder.addPackageFromDrl(reader);
//
//        Package builderPackage = packageBuilder.getPackage();
//
//        RuleBase ruleBase = RuleBaseFactory.newRuleBase();
//
//        ruleBase.addPackage(builderPackage);
//
//        WorkingMemory workingMemory = ruleBase.newStatefulSession();
//
//        // drools fine inizializzazione
//
//
//        //Inserimento del prodotto
//        Product product = new Product();
//
//        product.setType("gold");
//
//        // Inserimento nelle regole Drools
//        workingMemory.insert(product);
//
//        workingMemory.fireAllRules();
//
//        // verifica che le regole sono andate a buon fine
//        System.out.println("The discount for the product " + product.getType() + " is " + product.getDiscount());


        PackageBuilder packageBuilder = new PackageBuilder();

        String ruleFile = "resources\\Rule.drl";

        URL url = ClassLoader.getSystemResource("resources/Rule.drl");

        logger.info("{}", url);

        Path path = Paths.get(url.toString());

        InputStream resourceAsStream = getClass().getResourceAsStream(path.toString());

        logger.info("{}", resourceAsStream);

        Reader reader = new InputStreamReader(resourceAsStream);
        packageBuilder.addPackageFromDrl(reader);
        org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
        RuleBase ruleBase = RuleBaseFactory.newRuleBase();
        ruleBase.addPackage(rulesPackage);

        WorkingMemory workingMemory = ruleBase.newStatefulSession();

        Product product = new Product();
        product.setType("gold");

        workingMemory.insert(product);
        workingMemory.fireAllRules();

        System.out.println("The discount for the product " + product.getType()
                + " is " + product.getDiscount());

    }
}
