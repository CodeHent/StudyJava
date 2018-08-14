package test.chapter18;

import test.util.PPrint;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class Directory {
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(
                new FilenameFilter() {
                    private Pattern p = Pattern.compile(regex);

                    public boolean accept(File dir, String name) {
                        return p.matcher(new File(name).getName()).matches();
                    }
                }
        );
    }

    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();

        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return "TreeInfo{" +
                    "files=" + PPrint.pform(files) +"\n"+
                    "dirs=" + PPrint.pform(dirs) +
                    '}';
        }
    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start),regex);
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start,regex);
    }

    public static TreeInfo walk(File start) {
        return recurseDirs(start,".*");
    }

    public static TreeInfo walk(String start){
        return recurseDirs(new File(start),".*");
    }

    static TreeInfo recurseDirs(File startDir, String regex) {
        TreeInfo result = new TreeInfo();
        for (File iterm : startDir.listFiles()) {
            if (iterm.isDirectory()) {
                result.dirs.add(iterm);
                result.addAll(recurseDirs(iterm, regex));
            } else {
                if (startDir.getName().matches(regex)) {
                    result.files.add(iterm);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){

        if (args.length == 0){
            System.out.println(walk("."));
        }else {
            for (String arg : args){
                System.out.println(walk(arg));
            }
        }
    }
}

