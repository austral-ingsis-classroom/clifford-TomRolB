package edu.austral.ingsis.clifford;

public class File implements FileObject {
  private String name;
  private String content;

  public File(String name, String content) {
    this.name = name;
    this.content = content;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void rename(String name) {
    this.name = name;
  }

  public String getContent() {
    return content;
  }

  public void write(String content) {
    this.content = content;
  }
}
