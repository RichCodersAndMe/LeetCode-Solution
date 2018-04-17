# 库维护须知

请大家遵守规范，勤加维护。对规范有异议可以提出意见，经过讨论，并落地合理的规范。

注: 为方便阐述规范，以下内容以“使用**Java**语言解答**第001题**-**Two Sum**”为例进行说明。

## 目录
- [本仓库的起源](#本仓库的起源)
- [文档编写规范](#文档编写规范)
- [commit信息提交规范](#commit信息提交规范)
- [添加新语言代码](#添加新语言代码)
- [其他问题](#其他问题)

## 本仓库的起源
为避免误解，以下称[SDE603/LeetCode-Solution][lcs]为**本仓库**, 被介绍的仓库称为**此仓库**。
### 来源1: [@Blankj][blankj]的[awsome-java-leetcode][ajl]
**此仓库**由[@Blankj][blankj]于2017年4月18日创建, 不定期更新优质**Java**代码和题解，颇受好评，至今已有star数**3521**颗(star数量以仓库原址为准)。截止**本仓库**建立为止, **此仓库**已累计拥有**63**题已AC的Java代码。
### 来源2: [@Wang-YS][wys]的[leetcode][lc]
**此仓库**由[@Wang-YS][wys]于2018年2月28日创建，不定期更新优质**JavaScript**代码，属于个人练习项目。截止**本仓库**建立为止, **此仓库**已累计拥有**33**题已AC的JavaScript代码。
### 来源3 [@CodeAntStudio][cas]的[LeetCode-Solution][old-lcs]
**此仓库**由[@Mukyu][Mukyu]、[@Taryn][Taryn]、[@WangXin][wangxin]于2018年3月31日创建，由[@Mukyu][Mukyu]提供**Java**题解，[@Taryn][Taryn]提供**JavaScript**题解，[@WangXin][wangxin]提供**kotlin**题解，属于刚刚萌生想法的而创建的新仓库。截止**本仓库**建立为止, **此仓库**已累计拥有**5**题已AC的Java代码、**2**题已AC的JavaScript代码、**3**题已AC的kotlin代码。


## 文档编写规范 
 举例说明:  
 当提交首页表格未收录的题目时:   
  - 1 需提交对应解题代码->`./src/_001/Solution.java`
  - 2 对应的题目题解markdown文件(此文件填写规范参看[题解模板][template])->`./tips/001/README.md`
  - 3 在首页`README.md`对应的位置添加记录   
     - 3.1 根据题目难度(Easy、Medium、Hard),在对应的表格内的对应位置(根据题号排序)添加行
     - 3.2 添加原题地址（[001-question]: https://leetcode.com/problems/two-sum）
     - 3.3 添加题解地址 ([001-tips]: ./tips/001/README.md)  
     - 3.4 添加原题对应的**Tags**（就是在原题网页偏右下位置的`Related Topics`）
     - 3.5 添加代码地址 ([001-java]: ./src/_001/Solution.java)  
       (注: 同名的kotlin与Java类在同一个目录下会冲突,故kotlin放在更深一层的`kotlin`文件夹中:`./src/_001/kotlin/Solution.kt`)

 总而言之三步走: **代码**、**题解**、**首页README.md**

## commit信息提交规范
> feat：提交新的AC代码  
> fix：修补bug  
> docs：文档修改  
> style： 格式（不影响代码运行的变动）  
> refactor：重构（即不是新增功能，也不是修改bug的代码变动）  
> test：增加测试  
> chore：构建过程或辅助工具的变动  

基本可以按照上述情况对号入座, 还是不明白的参看*历史提交记录*(`git log`)。

commit前先pull, 尽量避免产生不必要的git分叉.  

commit信息模板: ``feat: add the solution of `Two Sum`(001) with Java``

## 添加新语言代码
目前已使用的代码有: `Java`、`JavaScript`、`kotlin`
添加新的语言的解题代码, 请按**字母序**排列，在**对应列**添加解题代码且附链接，文档编写相关细节参看[commit信息提交规范](#commit信息提交规范)。


## 其他问题
### 1 同题的同种语言的代码如何处理？
建议保留一份即可(优先保留高效代码), 如果有更好/值得一说的思路,可以在题解中体现。
如果非要保留自己的代码, 请遵守以下规则:
  - 首页README.md优先使用最优解的代码链接，认为最优解可以进一步优化或有更好的解法时，可通过提Issue的方式进行讨论和决定。
  - 如果同语言代码思路不同可以在**题解文档内**阐述思路,若思路相同，则不再赘述。
  - 文件名则改为: `Solution1.java`、`Solution2.java`、`Solution3.java`,以此类推。

### 2 未完善的题解
目前存在大量未完善的题解, 原因是[@Wang-YS][wys]大佬的原仓库没有写题解，只有已AC的js代码。
大概分散在561~804题。那个啥，大家努力完善吧。

[blankj]: https://github.com/Blankj
[ajl]: https://github.com/Blankj/awesome-java-leetcode
[wys]: https://github.com/Wang-YS
[lc]: https://github.com/Wang-YS/leetcode
[lcs]: https://github.com/SDE603/LeetCode-Solution
[old-lcs]: https://github.com/CodeAntStudio/LeetCode-Solution
[wangxin]: https://github.com/relish-wang
[Mukyu]: https://github.com/Mukyu
[Taryn]: https://github.com/Taryn2016
[cas]: https://github.com/CodeAntStudio
[template]: ./tips/Template.md
