<template>
    <div class="container">
        <list-table ref="table"></list-table>
        <list-page ref="page"></list-page>
        <modal ref="myModal"></modal>
    </div>
</template>

<script>
    import ListTable from '@/components/ListTable'
    import ListPage from '@/common/ListPage'
    import Modal from '@/common/Modal'
    
    export default {
        name: 'ListComp',
        components: {
            ListTable,
            ListPage,
            Modal
        }
    }
</script>
