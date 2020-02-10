package com.github.yukihane;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;

public class App {

    public static void main(final String[] args) {
        final InputStream src = App.class.getResourceAsStream("/MyClass.java");
        final BufferedReader reader = new BufferedReader(new InputStreamReader(src, StandardCharsets.UTF_8));
        final char[] chars = reader.lines().collect(Collectors.joining()).toCharArray();

        final ASTParser parser = ASTParser.newParser(AST.JLS13);
        parser.setSource(chars);
//        parser.setResolveBindings(true);

        final ASTNode node = parser.createAST(new NullProgressMonitor());

        node.accept(new ASTVisitor() {
            @Override
            public boolean visit(final ReturnStatement rs) {
                final Expression exp = rs.getExpression();
                exp.accept(new ASTVisitor() {
                    @Override
                    public boolean visit(final SimpleName sn) {
                        System.out.println(sn.toString());
                        return true;
                    }
                });
                return true;
            }
        });

    }

}
