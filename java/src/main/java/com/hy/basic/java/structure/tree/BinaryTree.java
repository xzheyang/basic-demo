package com.hy.basic.java.structure.tree;

/**
 * @user yang he
 * @date old
 * @introduce        二叉树
 **/
public class BinaryTree {

    /*
            概念解释
                树形结构,有一定顺序(左边的右节点和右边的左节点,导致不是完全有序)
                满足设x是二叉搜索树的一个节点，如果y是x左子树中的一个节点，
                那么y.key<x.key，如果y是x右子树中的一个节点，那么y.key>x.key。

            操作解释
                max,min: 最后一个左节点,最后一个右节点
                insert:  如果值比当前大去右节点,小去左节点,直到找到合适
                delete:  用右节点替换删除节点,原右节点依次被子右节点替换
                read:    依次查询,无此值是最后为null
               后继和前驱:   找出比当前大(小)的值,
                            如果当前值有右(左)节点,
                            找右(左)节点最小(大)值[右节点最左],
                            没有,找父节点的左(右)节点是当前,则是父节点,
                            如果不是则是往上寻找P[P节点是其父节点Q的左(右)边孩子]
                            --最后一句含义就是右既大,左既小,
                            --如果找比当前大值找寻右,如果自己是父的左边(我和父的规则相反)则父就是,
                            --否则就往上找自己是左边的那个点(同上面括号含义一样)

             总结
                    迭代是找寻的基础,只需要关注当前判断的点左是小,右是大即可;
                    eg:寻找前驱,如果左边有则进入左边(在比自己小的值找最大),
                        没有就找往上(比自己值大的找最小)
     */




}
