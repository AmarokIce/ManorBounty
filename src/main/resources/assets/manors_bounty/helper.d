import std.file;
import std.regex;

void main() {
    scanDir("./");
}

void scanDir(string dir) {
    auto entries = dirEntries(dir, SpanMode.shallow);
    foreach (DirEntry f; entries) {
        if (f.isDir) {
            scanDir(f.name);
        } else {
            fileHandler(f.name);
        }
    }
}

void fileHandler(string file) {
    import std.stdio : writeln;
    import std.string : indexOf, replace, endsWith;

    if (!file.endsWith(".json")) {
        return;
    }

    writeln(file);

    auto dat = readText(file);
    auto text = dat.replace("manors_bounty:texture/block", "manors_bounty:block");
    write(file, text);
}
