<template>
    <section>

        <!--工具条-->
        <el-col :span="24" class="toolbar" style="padding-bottom: 0px;">
            <el-form :inline="true" :model="filters">
                <el-form-item>
                    <el-input placeholder="关键字" v-model="filters.keywords"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="getDepartments">查询</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="add">新增</el-button>
                </el-form-item>
            </el-form>
        </el-col>

        <el-table :data="departments" loading="listLoading" highlight-current-row style="width: 100%;">

            <!--多选框-->
            <el-table-column type="selection" width="55">
            </el-table-column>

            <!--索引值.id不连续-->
            <el-table-column type="index" width="60">
            </el-table-column>

            <!--只有一个,不设置就会自动适应-->
            <el-table-column prop="name" label="名称">
            </el-table-column>
            <el-table-column label="操作" width="150">
                <template scope="scope">
                    <el-button size="small" @click="edit(scope.row)">编辑</el-button>
                    <el-button type="danger" size="small" @click="del(scope.row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <!--分页工具条-->
        <el-col :span="24" class="toolbar">
            <el-button type="danger">批量删除</el-button>
            <el-pagination layout="prev, pager, next" @current-change="handleCurrentChange" :page-size="10"
                           :total="total" style="float:right;">
            </el-pagination>
        </el-col>


        <!--添加或编辑对话框-->
        <el-dialog title="编辑" v-model="formVisible" :close-on-click-modal="false">
            <el-form :model="department" label-width="80px" :rules="formRules" ref="department">
                <el-form-item label="部门名称" prop="name">
                    <el-input v-model="department.name" auto-complete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="formVisible = false">取消</el-button>
                <el-button type="primary" @click="save">提交</el-button>
            </div>
        </el-dialog>
    </section>
</template>

<script>
    import util from "../../common/js/util";

    export default {
        data() {
            return {
                formVisible: false, //对话框默认不显示
                listLoading: false,
                filters: {   //高级查询对象
                    keywords: ''
                },
                page: 1,  //当前页,要传到后台的
                total: 0,   //分页总数
                departments: [],  //当前页数据
                department: {
                    id: null,
                    name: ''
                },
                // 表单检验规则
                formRules: {
                    name: [
                        {required: true, message: '请输入名字', trigger: 'blur'}
                    ]
                },
            }
        },
        methods: {
            handleCurrentChange(currentPage) {
                this.page = currentPage;
                this.getDepartments();
            },
            save() {
                // 判断是否有id 有就修改,否则就添加
                this.$refs.department.validate((valid) => {
                    // 校验表单成功才做一下操作
                    if (valid) {
                        this.$confirm('确认提交吗?', '提示', {}).then(() => {
                            // 拷贝后面对象的值到新对象,防止后面代码引起模型变化
                            let para = Object.assign({}, this.department);
                            this.$http.put('/department', para).then((res) => {
                                this.$message({
                                    message: '操作成功!',
                                    type: 'success'
                                });
                                // 重置表单
                                this.$refs['department'].resetFields();
                                // 关闭对话框
                                this.formVisible = false;
                                // 刷新数据
                                this.getDepartments();
                            });
                        })
                    }
                })
            },
            edit(row) { // row 中包含id  不需要添加隐藏域
                let departmentTmp = Object.assign({}, row); // 去除级联操作
                // 回显
                this.department = departmentTmp;
                this.formVisible = true
            },
            add() {
                this.department = {
                    id: null,
                    name: ''
                };
                this.formVisible = true;
            },
            getDepartments() {
                // 发送ajax请求,从后台获取数据 axios

                // 添加分页条件及高级查询条件
                let para = {
                    'page': this.page,
                    'keywords': this.filters.keywords
                };
                this.listLoading = true;   // 显示加载
                this.$http.post("/department", para)
                    .then(result => {
                        console.log(result);
                        this.total = result.data.total;
                        this.departments = result.data.rows;
                        this.listLoading = false;  //关闭加载
                    });

                // 查询所有
                // this.$http.patch("/department", para)
                //     .then(result => {
                //         console.log(result);
                //         this.departments = result.data;
                //         this.listLoading = false;
                //     });
            },
            del(row) {
                this.$confirm("确认删除吗?", "提示", {
                    type: "warning"
                }).then(() => {
                    var id = row.id;
                    this.listLoading = true;
                    this.$http.delete("/department/" + id)
                        .then(result => {
                            this.listLoading = false;
                            if (result.data.success) {
                                this.$message({
                                    message: '删除成功!',
                                    type: 'success'
                                })
                            } else {
                                this.$message({
                                    message: result.data.message,
                                    type: 'error'
                                });
                            }
                            this.getDepartments();
                        })
                });
            }
        },
        mounted() {
            this.getDepartments();
        }
    }

</script>

<style scoped>

</style>