package study.effective;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class BookWordCount {
    public static void main(String[] args) throws IOException, URISyntaxException {

        Map<Object, Long> bookWordCount = BookWordCount.pdfWordCount(Paths.get(ClassLoader.getSystemResource("Effective_java_3rd.pdf").toURI()));
        bookWordCount.entrySet().stream()
//                .filter(e->e.getValue()<20)
                .sorted( (f1,f2) ->Long.compare(f2.getValue(), f1.getValue()) )
                .limit(100)
                .forEach(e->log.info("{} : {}", e.getKey(),e.getValue()));
//                .forEach(e->System.out.print("\""+e.getKey()+"\","));
    }

    private static Map<Object, Long> pdfWordCount(Path pdf) throws IOException {
        Path tmp = Files.createTempFile("pdf_", ".txt");
        addShutdownHook(tmp);
        pdfToFile(pdf, tmp);

        Map<Object, Long> wordCount;
        try(Stream<String> lines = Files.lines(tmp)) {
            wordCount =lines
                    .flatMap(line-> Arrays.stream(line.split("[^@a-zA-Z]+")))
                    .map(s->s.trim())
                    .filter(s->s.length()>1)
                    .map(s->s.toLowerCase())
                    .filter(s-> !blackList.contains(s))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        }
        return wordCount;
    }

    static List<String> blackList = Arrays.asList(
            "the","to","a","of","is","and","in","that","it", "you", "this", "for", "method", "class", "if","an","be",
            "are","the","as","with","code","s","or","type", "can","t","object","not","public","item","use","here","by",
            "on","if","but","item","if","this", "return","view","which","click","static","java","image","its","methods",
            "have","new","from","static","should","string","will","int","one","list","all","example","private","when",
            "instance","interface","classes","there","do","value","no","so","because","types","these", "they", "set",
            "program","more","exception","such","your","enum","only","each","final","may","any","has","collection",
            "implementation","field","using","objects","fields","time","stream","two","elements","at","than","must",
            "result","double","used","would","array","thread", "other","api","equals","performace","first","make",
            "does","constructor","map","element","was","while","out","write","parameter", "same","values","interfaces",
            "them","system","returns","their","many","provide","void","add","size","then","number","don","annotation",
            "throw","instances","exceptions","get","case","re","what","null","need","default","we","reference","also",
            "function","consider","key","generic","client","without","operation","form","clone","even","test","second",
            "single","uses","were","immutable","most","access","compile","could","implement", "problem", "data",
            "optional","long","state", "how", "error","try","whose","where","stack","instead","added","note",
            "declaration","both","performance", "into","some","parameters","way","boolean","integer","every","possible",
            "unchecked","streams","collections", "extends","serialized","work","pint","want","constant","best",
            "constructors","like","name","pattern","over","factory","runtime","serializable","good","start","takes",
            "programmers","libraries","another","variable","behavior","period","package","multiple","serialization",
            "check","arrays","point","order","implementations","simple","version","end","cast","required","subclass",
            "args","been","contains","clients","hashcode","words","run","comparator","override","known","implements",
            "about","documentation","generally","loop","might","never","level","three","mutable","hash","main",
            "compiler","member","iterator","abstract","well","builder","writing","call","language","create","better",
            "comparable","standard","approach","suppose","date","whether","different","@override","true","argument",
            "provides","my","failure","part","designed","change","information","varargs","summary","platform",
            "inheritance","less","references","always","book","threads","complex","println","still","throws",
            "synchronization","invoked","after","next","our","therefore","before","safety","synchronized","just","safe",
            "representation","entry","contract","names","tostring","resulting","constants","once","between","place",
            "rather","index","copy","take","passed","unless","document","declared","warning","fact","makes","pass",
            "wildcard","design","put","fail","following","empty","source","length","apply","often","super","simply",
            "avoid","bit","release","ensure","line","original","see","annotations","concurrent","doesn","compareto",
            "up","cause","based","jls","easy","catch","much","returned","superclass","invoke","too","checked","finally",
            "biginteger","programming","allows","know","generics","readobject","special","programmer","util","hashset",
            "read","invocation","initialization","requires","common","now","wrong","previous","existing","cannot",
            "containing","elvis","won","ll","own","chapter","functional","however","byte","called","non","correct",
            "itself","reason","generate","few","strings","raw","phonenumber","parameterized","doc","computation",
            "components","remove","native","find","prefer","important","made","subclasses","specified","lambda",
            "protected","overloading","operations","resources","local","contain","tag","nested","technique","lock",
            "boxed","associated","represents","singleton","arguments","iterable","items","sequence","looks","framework",
            "members","primitives","making","created","compare","marker","enums","phase","perform","general","sort",
            "programs","comment","factories","let","memory","equal","under","practice","named","had","given",
            "represent","difficult","false","directly","declare","hard","third","likely","necessary","service","rule",
            "isn","lambdas","warnings","either","collector","errors","comments","though","include","detail","wait",
            "file","anonymous","typically","readresolve","times","overriding","returning","allow","far","extend",
            "process","defensive","think","page","internal","advantage","define","cost","action","real","yourself",
            "implementing","exactly","prints","useful","apis","guarantee","support","alternative","clear","typesafe"
    );

    private static void addShutdownHook(Path tmp) {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                Files.delete(tmp);
            } catch (IOException e) {
                e.printStackTrace();
            }
            log.info("shutdown hook completed");
        }));
    }

    private static void pdfToFile(Path source, Path tmp) throws IOException {
        try(BufferedWriter writer = Files.newBufferedWriter( tmp )) {
            PDDocument document = PDDocument.load(source.toFile());
            PDFTextStripper stripper = new PDFTextStripper();

            stripper.setStartPage(1);
            stripper.setEndPage(405);
            stripper.writeText(document, writer);
            document.close();
        }
    }
}
