package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.ListUtilities;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

import java.util.List;

/**
 * Created by Administrator on 2016/10/31.
 */
public class AllFieldsElementGenerator extends AbstractXmlElementGenerator {

    public AllFieldsElementGenerator() {
        super();
    }


    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("sql"); //$NON-NLS-1$
        answer.addAttribute(new Attribute(
                "id", "allFields")); //$NON-NLS-1$
        StringBuilder sb = new StringBuilder();
        List<IntrospectedColumn> columns = ListUtilities.removeIdentityAndGeneratedAlwaysColumns(introspectedTable.getAllColumns());
        for (int i = 0; i < columns.size(); i++) {
            IntrospectedColumn introspectedColumn = columns.get(i);
            sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
            if (i + 1 < columns.size()) {
                sb.append(", "); //$NON-NLS-1$
            }
        }
        answer.addElement(new TextElement(sb.toString()));
        parentElement.addElement(answer);
    }
}
