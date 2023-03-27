import org.example.EmailValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmailValidatorTest {

    private EmailValidator emailValidator;
    @BeforeClass
    public void beforeClass(){
        emailValidator = new EmailValidator();
    }

    @Test(dataProvider = "emails")
    public void checkEmail(String email, boolean isValid){
        if(isValid){
            Assert.assertTrue(emailValidator.checkEmail(email));
        }else{
            Assert.assertFalse(emailValidator.checkEmail(email));
        }
    }

    @DataProvider(name = "emails")
    public static Object[][] evenNumbers() {
        return new Object[][]{
                //invalid
                {"aaa@aaa", false}, //domain 1lvl
                {"1aaa@aaa.aa", false}, //starts with a number
                {"a.@abcds.xc", false}, //ends with a dot
                {"aBCS.scs.dk", false}, //without @
                {"sddf@dssf.s", false}, //1 letter in domain
                {"sddf.@dssf.sd", false}, //ends with a dot
                {".sddf@dssf.sd", false}, //starts with a dot
                {"sddf@.dssf.sd", false}, //domain starts with a dot
                {"sddf@ds..sf.sd", false}, //double dots
                {"sd@df@ds.sf.sd", false}, //double @
                {"sddf@@ds.sf.sd", false}, //double @
                {"sd1f-2s1@abd.zx",false}, //contains a symbol
                {null,false}, //null
                //valid
                {"sd1f2s1@abd.zx",true},
                {"sd1f.2s1@abd.zx",true},
                {"s@abd.zx",true},
                {"sd1f.2s1@sd.abd.zx",true},
                {"DSDFE23.FC@DEF.PKJ",true},
                {"sd1f.2s1@sss-d.sd.abd.zx",true},
        };
    }
}
