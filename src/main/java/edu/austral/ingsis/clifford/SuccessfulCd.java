package edu.austral.ingsis.clifford;

import java.util.List;

public record SuccessfulCd(List<Directory> dirPath) implements CdResult {}
