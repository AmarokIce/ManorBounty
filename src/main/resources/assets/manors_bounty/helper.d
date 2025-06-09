import std.string;
import std.file;
import std.regex;

void main() {
    scanDir("./");
}

void scanDir(string dir) {
    auto entries = dirEntries(dir, SpanMode.shallow);
    foreach(DirEntry f; entries) {
        if (f.isDir) {
            scanDir(f.name);
        } else {
            fileHandler(f.name);
        }
    }
}

void fileHandler(string file) {
    import std.stdio: writeln;

    if (!file.endsWith(".json") || file.indexOfAny("door") == -1) {
        return;
    }

    writeln(file);

    auto dat = readText(file);
    auto text = dat.replace("button", "bottom");
    write(file, text);
}
